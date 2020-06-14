package com.compare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PDFDownload {

	WebDriver driver;

	public PDFDownload (WebDriver driver) { 
		this.driver = driver; 
	} 

	//Locating elements 
	@FindBy(id = "s")
	WebElement txt_searchBook;

	@FindBy(id = "searchsubmit")
	WebElement bt_search;

	@FindBy(xpath = "//span[contains(text(), 'Get it Now')]")
	WebElement bt_getItNow;

	@FindBy(xpath = "//span[contains(text(), 'PDF')]")
	WebElement bt_pdf;

	@FindBy(xpath = "/html/body/div[3]/div[6]/div[3]/a")
	WebElement bt_download;

	@FindBy(id = "onesignal-popover-cancel-button")
	WebElement pop_up;

	public void downloadPDF(String bookName) throws Exception {
		
		POMTest.wait.until(ExpectedConditions.elementToBeClickable(txt_searchBook));
		txt_searchBook.sendKeys(bookName);
		bt_search.submit();
		POMTest.wait.until(ExpectedConditions.elementToBeClickable(bt_getItNow));
		//Thread.sleep(5000);
		bt_getItNow.click();
		POMTest.wait.until(ExpectedConditions.elementToBeClickable(bt_pdf));
		bt_pdf.click();
		POMTest.wait.until(ExpectedConditions.elementToBeClickable(bt_download));
		bt_download.click();
	}

}
