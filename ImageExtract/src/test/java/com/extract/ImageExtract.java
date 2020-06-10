package com.extract;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImageExtract {
	
	WebDriver driver;
	String url = "";
	String filePath = "";

	@BeforeTest
	public void before_test() throws Exception {

		// Disabling Chrome notifications
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--disable-notifications");

		// Initializing browser driver
		driver = new FirefoxDriver(op);
		driver.manage().window().maximize();
		
		FileReader reader = new FileReader("values.properties");
		Properties prop = new Properties();
		prop.load(reader);
		
		url = prop.getProperty("URL");
		filePath = prop.getProperty("FolderPath");
		
		// Navigate to URL
		driver.get(url);

	}
	

	@Test(enabled = true)
	public void image_extract() throws Exception {

		String image = "";
		
		List<WebElement> img = driver.findElements(By.tagName("img"));
		Iterator<WebElement> it = img.iterator();
		while(it.hasNext()) {

			image = it.next().getAttribute("src");
			System.out.println(image);

			URL imageURL = new URL(image);
			BufferedImage saveImage = ImageIO.read(imageURL);

			ImageIO.write(saveImage, "png", new File(filePath+System.currentTimeMillis()+".png"));
		}
	}

	@AfterTest
	public void after_test() {

		driver.quit();
	}


}
