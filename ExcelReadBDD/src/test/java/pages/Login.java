package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import stepDefination.Steps;

public class Login {
	
	public WebDriver driver;
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	WebElement bt_login;
	
	@FindBy(id = "email")
	WebElement txt_email;
	
	@FindBy(id = "password")
	WebElement txt_password;
	
	@FindBy(id = "submit-button")
	WebElement bt_submit;
	
	public void navigate() {
		driver.get("https://stackoverflow.com/");
		Steps.wait.until(ExpectedConditions.visibilityOf(bt_login));
		bt_login.click();
	}
	
	public void enterEmail(String email) {
		Steps.wait.until(ExpectedConditions.visibilityOf(txt_email));
		txt_email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		Steps.wait.until(ExpectedConditions.visibilityOf(txt_password));
		txt_password.sendKeys(password);
	}
	
	public void clickSubmit() {
		Steps.wait.until(ExpectedConditions.visibilityOf(bt_submit));
		bt_submit.click();
	}
	
}
