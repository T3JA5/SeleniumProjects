package com.yatra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectFlight {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//button[contains(text(),'Book')]")
	WebElement book;
	
	@FindBy(id = "paymentDesktopLogo")
	WebElement bt_yatra;
	
	@FindBy(id = "origin_0")
	WebElement lb_dest;
	
	@FindBy(id = "destination_0")
	WebElement lb_src;
	
	public SelectFlight(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validate(String expected_src, String expected_dest) throws Exception {
		
		Thread.sleep(6000);
		String actual_src = lb_src.getAttribute("ng-msvalidate");
		Assert.assertEquals(actual_src, expected_src);
		String actual_dest = lb_dest.getAttribute("ng-msvalidate");
		Assert.assertEquals(actual_dest, expected_dest);
	}
	
	// Click on book of first row of flight
	public void book_first() throws Exception {
		Thread.sleep(7000);
		book.click();
		Thread.sleep(7000);
		bt_yatra.click();
		Thread.sleep(7000);
	}

}
