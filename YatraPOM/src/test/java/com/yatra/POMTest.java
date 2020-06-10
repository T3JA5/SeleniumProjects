package com.yatra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class POMTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public void before_test() {

		// Disabling Chrome notifications
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");

		// Initializing browser driver
		driver = new ChromeDriver(op);
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();

		// Navigate to Yatra.com
		driver.get("https://www.yatra.com/");

	}
	
	@DataProvider(name = "oneway")
	public Object[][] oneway(){
		return new Object[][] {
			{"DEL", "PNQ", "15/12/2020", 3}
		};
	}

	// One way trip booking
	@Test(enabled = true, dataProvider = "oneway")
	public void book_flight_one_way(String src, String dest, String src_date, int passanger) throws Exception {

		// create object of class
		SearchFlights sf = PageFactory.initElements(driver, SearchFlights.class);
		SelectFlight select = sf.search_flight_one_way(src, dest, src_date, passanger);
		select.validate("New Delhi ("+src+")", "Pune ("+dest+")");
		select.book_first();

	}
	
	@DataProvider(name = "round")
	public Object[][] round(){
		return new Object[][] {
			{"DEL", "BOM", "20/12/2020", "21/12/2020", 4}
		};
	}

	// round trip booking
	@Test(enabled = true, dataProvider = "round")
	public void book_flight_round_trip(String src, String dest, String src_date, String dest_date, int passanger) throws Exception {
		
		// create object of class
		SearchFlights sf = PageFactory.initElements(driver, SearchFlights.class);
		SelectFlight select = sf.search_flight_round(src, dest, src_date, dest_date, passanger);
		select.validate("New Delhi ("+src+")", "Mumbai ("+dest+")");
		select.book_first();
	}
	
	@AfterMethod
	public void after_test() {

		driver.quit();
	}
}
