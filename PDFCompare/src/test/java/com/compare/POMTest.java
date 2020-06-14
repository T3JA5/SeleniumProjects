package com.compare;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMTest {

	WebDriver driver;
	static WebDriverWait wait;

	@BeforeMethod()
	public void beforeTest() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 20);

	}

	
	// Download 2 PDF file and compare, log the difference
	@Test(enabled = false)
	public void downloadAndCompare() throws Exception {
		
		driver.get("http://www.freebooks.com/");
		PDFDownload down = PageFactory.initElements(driver, PDFDownload.class);

		String bookName = "Abraham Lincoln";
		down.downloadPDF(bookName);
		String book = bookName.replace(' ', '-').toLowerCase();
		System.out.println(book);
		Thread.sleep(20000);
		String fileLoc = "C:\\Users\\T3j45\\Downloads\\"+book+".pdf";
		File file1 = Conversion.convertToText(fileLoc);
		System.out.println("---------------------------------------------");
		String bookName1 = "Love Letters";
		down.downloadPDF(bookName1);
		String book1 = bookName1.replace(' ', '-').toLowerCase();
		System.out.println(book1);
		Thread.sleep(20000);
		String fileLoc1 = "C:\\Users\\T3j45\\Downloads\\"+book1+".pdf";
		File file2 = Conversion.convertToText(fileLoc1);
		
		Conversion.compareTextFile(file1, file2);
		
	}
	
	// Compare the local PDF file and log the difference
	@Test(enabled = true)
	public void comparePDF () throws Exception {
		
		File file1 = Conversion.convertToText("Tejas.pdf");
		File file2 = Conversion.convertToText("Vishal.pdf");
		
		Conversion.compareTextFile(file1, file2);
		
	}
	
	@AfterMethod
	public void afterTest() {

		driver.quit();

	}
}
