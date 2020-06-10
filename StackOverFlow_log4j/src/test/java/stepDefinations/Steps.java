package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SOLogin;

public class Steps {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public SOLogin login;
	public static ExtentTest test = null;
	public static ExtentReports report = null;
	

	static Logger logger = LogManager.getLogger(Steps.class);
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {	

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		login = PageFactory.initElements(driver, SOLogin.class);
		// Extent reports objects
    	report = new ExtentReports("E:\\Automation\\Reports\\stackOverflow.html");
    	test = report.startTest("stackOverflow");

	}

	@When("User navigates to URL")
	public void user_navigates_to_URL() throws Exception {

		login.navigate();
		logger.info("Navigate to desired url");

	}


	@And("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String email, String password) throws Exception {

		login.enterEmail(email);
		login.enterPassword(password);
		logger.info("Entering email and password");

	}

	@And("Click on Log in")
	public void click_on_Log_in() throws Exception {
		login.loginButton();
		logger.info("Click on Login button");
		Thread.sleep(5000);

	}

	@Then("Page titles should be {string}")
	public void page_titles_should_be(String title) throws Exception {
		
		
		if(driver.getPageSource().contains("The email or password is incorrect.")) {
			logger.error("Login failed");
			Assert.assertTrue(false);
		}
		else if(driver.getPageSource().contains("Human verification")) {
			logger.error("Login failed");
			Assert.assertTrue(false);
		}	
		else {
			Thread.sleep(5000);
			Assert.assertEquals(driver.getTitle(), title);
			logger.info("Login successful");
		}
	}

	@And("close browser")
	public void close_browser() throws Exception {
		driver.quit();
	}

}
