package stepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import excel.GetdatafromExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class Steps {


	public static WebDriver driver;
	public static WebDriverWait wait;
	public Login login;
	public GetdatafromExcel excelRead;

	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
		login = PageFactory.initElements(driver, Login.class);

		// Excel objects
		String excelPath = "C:\\Users\\T3j45\\eclipse-workspace\\ExcelReadBDD\\src\\test\\resources\\TestData.xlsx";
		String sheetName = "test";
		excelRead = new GetdatafromExcel(excelPath, sheetName);
	}

	@When("User navigates to URL")
	public void user_navigates_to_URL() {

		login.navigate();
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() {

		login.enterEmail(excelRead.getData(2, 0));
		login.enterPassword(excelRead.getData(2, 1));
	}

	@When("Click on Log in")
	public void click_on_Log_in() throws Exception {

		login.clickSubmit();
		Thread.sleep(5000);
	}

	@Then("Check the page title")
	public void check_the_page_title() {

		Assert.assertEquals(driver.getTitle(), excelRead.getData(2, 2));
		System.out.println("Login successfully");
	}

	@Then("close browser")
	public void close_browser() {

		driver.quit();  
	}

}