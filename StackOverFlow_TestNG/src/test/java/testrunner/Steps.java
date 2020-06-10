package testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public SOLogin login;	
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {	

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		login = PageFactory.initElements(driver, SOLogin.class);  
	}

	@When("User navigates to URL")
	public void user_navigates_to_URL() throws Exception {

		login.navigate();

	}


	@And("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String email, String password) throws Exception {

		login.enterEmail(email);
		login.enterPassword(password);

	}

	@And("Click on Log in")
	public void click_on_Log_in() throws Exception {
		login.loginButton();
		Thread.sleep(5000);

	}

	@Then("Page titles should be {string}")
	public void page_titles_should_be(String title) throws Exception {
		
		
		if(driver.getPageSource().contains("The email or password is incorrect.")) {
			TakeScreenshot.screenshot();
			System.out.println("Login failed due to invalid credentials");
			Assert.assertTrue(false);
			driver.close();
		}
		else if(driver.getPageSource().contains("Human verification")) {
			TakeScreenshot.screenshot();
			System.out.println("Human verification needed");
			Assert.assertTrue(false);
			driver.close();
		}	
		else {
			Thread.sleep(5000);
			TakeScreenshot.screenshot();
			System.out.println("Login successful");
			Assert.assertEquals(driver.getTitle(), title);
		}
	}

	@And("close browser")
	public void close_browser() throws Exception {
		driver.quit();
	}

}
