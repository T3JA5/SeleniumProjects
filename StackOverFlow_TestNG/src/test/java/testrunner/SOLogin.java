package testrunner;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SOLogin { 

	WebDriver driver;

	public SOLogin(WebDriver driver) { 
		this.driver = driver; 
	} 

	// Locating elements
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	WebElement login;

	@FindBy(id = "email")
	WebElement txt_email;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement bt_login;

	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(xpath = "//a[@title = 'A list of all 176 Stack Exchange sites']")
	WebElement bt_list;

	@FindBy(xpath = "//a[contains(text(),'log out')]")
	WebElement bt_logout;

	@FindBy(xpath = "//button[contains(text(),'Log out')]")
	WebElement bt_logout_2;

	@FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/p")
	WebElement lb_error;


	// Navigate to URL
	public void navigate() throws Exception {
		driver.get("https://stackoverflow.com/");
		driver.manage().window().maximize();
		Steps.wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
	}

	// Enter Email in the email text box 
	public void enterEmail(String email) throws Exception {
		System.out.println("Login Page");
		Steps.wait.until(ExpectedConditions.visibilityOf(txt_email));
		txt_email.sendKeys(email);
	}

	// Enter Password in the password text box 
	public void enterPassword(String password) throws Exception {
		Steps.wait.until(ExpectedConditions.visibilityOf(txt_password));
		txt_password.sendKeys(password); 
	}

	// Click on Next Button 
	public void loginButton() throws Exception {
		Steps.wait.until(ExpectedConditions.elementToBeClickable(bt_login));
		bt_login.click();
	} 

	// Error page
	public void loginFailed() throws Exception {
		Steps.wait.until(ExpectedConditions.visibilityOf(lb_error));
		System.out.println(lb_error.getText());
	}
} 
