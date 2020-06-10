package com.yatra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFlights {

	WebDriver driver;

	// Locating elements
	@FindBy(id = "BE_flight_origin_city")
	WebElement txt_depart_loc;

	@FindBy(id = "BE_flight_arrival_city")
	WebElement txt_arrival_loc;

	@FindBy(id = "BE_flight_origin_date")
	WebElement txt_depart_date;

	@FindBy(xpath = "//*[@id=\"BE_flight_paxInfoBox\"]/i")
	WebElement bt_passanger;

	@FindBy(xpath ="//*[@id=\"BE_flight_passengerBox\"]/div[1]/div[1]/div/div/span[2]")
	WebElement bt_adults;

	@FindBy(id = "BE_flight_flsearch_btn")
	WebElement bt_search_flight;

	@FindBy(xpath = "//a[contains(text(),'Round Trip')]")
	WebElement bt_round_trip;

	@FindBy(id = "BE_flight_arrival_date")
	WebElement txt_arrival_date;
	

	public SearchFlights(WebDriver driver) {
		this.driver = driver;
	}

	// Select depart city
	public void departCity(String depart_city) throws Exception {
		txt_depart_loc.clear();
		//Thread.sleep(4000);
		txt_depart_loc.sendKeys(depart_city);
		Thread.sleep(4000);
		txt_depart_loc.sendKeys(Keys.ENTER);
	}

	// Select arrival city
	public void arrvialCity(String arrival_city) throws Exception {
		Thread.sleep(4000);
		txt_arrival_loc.clear();
		//Thread.sleep(4000);
		txt_arrival_loc.sendKeys(arrival_city);
		Thread.sleep(4000);
		txt_arrival_loc.sendKeys(Keys.ENTER);
	}

	// Select the depart date
	public void dateSelect(String date_journey) throws Exception {
		Thread.sleep(4000);
		txt_depart_date.click();
		Thread.sleep(4000);
		WebElement sel_date = driver.findElement(By.id(date_journey));
		sel_date.click();
		Thread.sleep(3000);
	}

	// Select the arrival date
	public void dateSelect_1(String date_journey_1) throws Exception {
		Thread.sleep(4000);
		txt_arrival_date.click();
		Thread.sleep(4000);
		WebElement sel_date = driver.findElement(By.id(date_journey_1));
		sel_date.click();
		Thread.sleep(3000);
	}

	// Select the number of travelers
	public void traverllers(int num_passg) throws Exception {
		Thread.sleep(4000);
		bt_passanger.click();
		Thread.sleep(4000);
		if(num_passg > 2) {
			for(int i=2;i<=num_passg;i++)
				bt_adults.click();
		}
	}

	// Click on search
	public SelectFlight clickSearch() throws Exception { 
		Thread.sleep(2000);
		bt_search_flight.click();
		return PageFactory.initElements(driver, SelectFlight.class); 		
	}
	
	// Click on round trip button
	public void roundClick() throws Exception {
		Thread.sleep(3000);
		bt_round_trip.click();
		Thread.sleep(3000);
	}

	// Search the flight for one way trip
	public SelectFlight search_flight_one_way(String depart_city, String arrival_city, String date_journey, int num_passg ) throws Exception {

		departCity(depart_city);
		arrvialCity(arrival_city);
		dateSelect(date_journey);
		traverllers(num_passg);
		return clickSearch();
	}

	// Search the flight for one way trip
	public SelectFlight search_flight_round(String depart_city, String arrival_city, String date_journey, String date_journey_1, int num_passg ) throws Exception {
		
		roundClick();
		departCity(depart_city);
		arrvialCity(arrival_city);
		dateSelect(date_journey);
		dateSelect_1(date_journey_1);
		traverllers(num_passg);
		return clickSearch();
	}

}
