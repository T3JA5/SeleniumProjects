package com.extract;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMTest {

	WebDriver driver;

	@BeforeTest
	public void before_test() {

		// Disabling Chrome notifications
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");

		// Initializing browser driver
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();

		// Navigate to Medibank
		driver.get("https://www.medibank.com.au/");

	}

	@Test(enabled = true)
	public void extract_links() throws Exception {
		String url = "";

		try {

			List<WebElement> links = driver.findElements(By.tagName("a"));

			Iterator<WebElement> it = links.iterator();
			System.out.println("List of urls in page are :: ");

			while(it.hasNext()){

				url = it.next().getAttribute("href");

				if (url == null ){

					System.out.println(url+" :: URL is either not configured for anchor tag or it is empty");
				}
				else if (url.contains("http") || url.contains("ftp")) {
					System.out.println(url+" :: Valid url started with https or http or ftp");
				}

				else { System.out.println(url+" :: Invalid URL's"); }


			}

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}


	@Test(enabled = true)
	public void extract_para() throws Exception {
		WebElement parag;

		try {

			List<WebElement> para = driver.findElements(By.tagName("p"));

			Iterator<WebElement> itr = para.iterator();
			System.out.println("List of paragraphs in page are :: ");

			while(itr.hasNext()){

				parag = itr.next();
				System.out.println(parag.getText().trim());

			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}

	@AfterTest
	public void after_test() {

		driver.quit();
	}
}
