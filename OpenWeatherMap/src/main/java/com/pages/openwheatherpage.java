package com.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.exceptions.CsvValidationException;
import com.qa.util.CSVReaderExample;

public class openwheatherpage {

	private WebDriver driver;

	
	/*
	 * 
	 * Elements
	 * 
	 * 
	 * 
	 */
	
	@FindBy(xpath = "//input[@placeholder='Search city']")
	private WebElement search_userfield;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")	
	private WebElement click_search_button;

	@FindBy(xpath = "//span[text()='Pune, IN ']")
	private WebElement pune_searched_text;
	
	@FindBy(xpath = "//span[contains(text(),'Humidity:')]")
	private WebElement Humidity;
	
	@FindBy(xpath = "//span[contains(text(),'Dew point:')]")
	private WebElement DewPoint;
	
	@FindBy(xpath = "//span[contains(text(),'Visibility:')]")
	private WebElement Visibility;
	
//	@FindBy(xpath = "//span[contains(text(),'UV:')]")
//	private WebElement UV;
	
	@FindBy(xpath = "//*[@class='icon-current-location']")
	private WebElement Location_Icon;
	
	@FindBy(xpath = "//h2[contains(text(),'Sirūr, IN')]")
	private WebElement City_Name;

	@FindBy(xpath = "//span[contains(text(),'No results for')]")
	private WebElement get_no_result_response;

	@FindBy(xpath = "(//a[text()='Maps'])[1]")
	private WebElement maps;

	@FindBy(xpath = "//span[text()=' Global Precipitation']")
	private WebElement clickGlobal_precipation;

	@FindBy(xpath = "//span[text()=' Clouds']")
	private WebElement click_clouds;

	@FindBy(xpath = "//span[text()=' Wind speed']")
	private WebElement click_WindSpeed;

	@FindBy(xpath = "//span[text()=' Temperature']")
	private WebElement click_temperature;

	@FindBy(xpath = "//span[text()=' Pressure']")
	private WebElement click_pressure;
	
	
	
	/*
	 * 
	 * constructors
	 * 
	 * 
	 * 
	 */

	public openwheatherpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * 
	 * Methods
	 * 
	 * 
	 * 
	 */

	
	public void enter_city_name() throws CsvValidationException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(search_userfield));
		search_userfield.sendKeys(CSVReaderExample.eu.read_csv_data(1, 0, 0));
	}
	
	public void click_search_button() {
		 WebElement targetElement = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='owm-loader']")));
		        wait.until(ExpectedConditions.elementToBeClickable(targetElement));
		        click_search_button.click();
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(click_search_button));
//		click_search_button.click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
  	}


	public boolean Pune_searched_text_is_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pune_searched_text));
		
		return pune_searched_text.isDisplayed();
	}


	public void click_Pune() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pune_searched_text));
		pune_searched_text.click();
		
	}


	public void weather_data_is_displayed() {
		Humidity.isDisplayed();
		DewPoint.isDisplayed();
		Visibility.isDisplayed();
//		UV.isDisplayed();
		
	}


	public void click_location_icon() {
		  WebElement targetElement = driver.findElement(By.xpath("//*[@class='icon-current-location']"));

		// WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='owm-loader']")));
	        wait.until(ExpectedConditions.elementToBeClickable(targetElement));
	        Location_Icon.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(Location_Icon));
//		Location_Icon.click();
			
	}


	public String get_cityname() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(City_Name));
		String str = City_Name.getText();
		System.out.println(str);
		return str;
		
	}


	public void search_city__searchbar(String string) {
		search_userfield.sendKeys(string);
		click_search_button.click();
		
	}


	public boolean get_no_result_response() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(get_no_result_response));
		return get_no_result_response.isDisplayed();
	}


	public void click_Maps() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(maps));
		maps.click();
		
	}


	public void clickGlobal_precipation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickGlobal_precipation));
		clickGlobal_precipation.click();
		
	}


	public void click_clouds() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_clouds));
		click_clouds.click();
		
	}

	public void click_WindSpeed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_WindSpeed));
		click_WindSpeed.click();
		
	}


	public void click_temperature() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_temperature));
		click_temperature.click();
		
	}


	public void click_pressure() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_pressure));
		click_pressure.click();
		
	}


	public void Global_precipationis_toggledandViewed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickGlobal_precipation));
		clickGlobal_precipation.isDisplayed();
		
	}


	public void clouds_toggledandViewed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_clouds));
		click_clouds.isDisplayed();
		
		
	}


	public void WindSpeed_toggledandViewed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_WindSpeed));
		click_WindSpeed.isDisplayed();
		
	}


	public void temperature_toggledandViewed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_temperature));
		click_temperature.isDisplayed();
		
	}


	public void pressure_toggledandViewed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(click_pressure));
		click_pressure.isDisplayed();
		
	}


	




}
