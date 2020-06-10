package runner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import reporter.ReportCreation;
import takescreenshot.TakeScreenshot;

public class POMTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	// Before Test
	@BeforeTest
	public void beforeTest() {

		// Disabling Chrome notifications
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");

		// Initializing browser driver
		driver = new ChromeDriver(op);
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		// Navigate to Saleforce url
		driver.get("https://login.salesforce.com/");

	}

	@Test
	public void pomTest() throws Exception {

		// Reading properties file
		Properties p=new Properties();  
		p.load(getClass().getClassLoader().getResourceAsStream("login.properties")); 

		// Create Login class object
		Login login = PageFactory.initElements(driver, Login.class);
		login.enterUserName(p.getProperty("UserName"));

		// Decoding password
		String password = p.getProperty("Password");
		byte[] decodePassword = Base64.getDecoder().decode(password.getBytes());

		// Enter the decoded password
		login.enterPassword(new String(decodePassword));
		// Take screenshot
		TakeScreenshot.screenshot("E:\\Automation\\Screenshots\\BeforeLogin.png", "png");
		login.clickSubmit();
		TakeScreenshot.screenshot("E:\\Automation\\Screenshots\\AfterLogin.png", "png");

	}

	// After test
	@AfterTest
	public void afterTest() throws Exception {
		
		// Create new folder with Date and Time
		String Foldername = new SimpleDateFormat("DDMMYY_HHmmss").format(new Date());
		File srcFolder = new File("./test-output");
		File destFolder = new File(Foldername);

		// Check if source folder exists
		if(!srcFolder.exists())
		{
			System.out.println("Directory does not exist at mentioned location.");
			//just exit
			System.exit(0);
		}
		else
		{
			// copy the file from source to destination
			try
			{
				ReportCreation.copyFolder(srcFolder,destFolder);
			}
			catch(IOException e){
				e.printStackTrace();
				//error, just exit
				System.exit(0);
			}
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
