package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import runner.POMTest;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		driver = this.driver;
	}
	
	// Locating web elements
	@FindBy(id = "username")
	WebElement txt_user;
	
	@FindBy(id = "password")
	WebElement txt_pwd;
	
	@FindBy(id = "Login")
	WebElement bt_login;
	
	@FindBy(xpath = "//h2[contains(text(),'Verify Your Identity')]")
	WebElement lb_verify;
	
	@FindBy(id = "error")
	WebElement lb_error;
	
	// Enter username
	public void enterUserName(String username) {
		
		POMTest.wait.until(ExpectedConditions.visibilityOf(txt_user));
		txt_user.sendKeys(username);
	}
	
	// Enter password
	public void enterPassword(String password) {
		
		POMTest.wait.until(ExpectedConditions.visibilityOf(txt_pwd));
		txt_pwd.sendKeys(password);
	}
	
	// Click submit
	public void clickSubmit() {
		
		POMTest.wait.until(ExpectedConditions.visibilityOf(bt_login));
		bt_login.click();
		if(lb_verify.isDisplayed()) {	
			System.out.println("Login successful");
			Assert.assertEquals(lb_verify.getText(), "Verify Your Identity");
			Reporter.log("Login Successful");
			
		}
		else {
			System.out.println("Please check the username and passowrd. Login failed.");
			System.out.println(lb_error.getText());
			Assert.assertFalse(true);
			Reporter.log(lb_error.getText());
		}
	}

}
