package stepdefinitions;

import org.junit.Assert;

import com.pages.openwheatherpage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class openwheather {
	private openwheatherpage fp = new openwheatherpage(DriverFactory.getDriver());
	

	/*
	 * 
	 * 
	 * TC1
	 * 
	 * 
	 */

	@Given("User Navigate to Homepage")
	public void user_navigate_to_homepage() {
	    DriverFactory.getDriver().get("https://openweathermap.org/");
	    
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    ApplicationHooks.scn.log("User Navigate to Homepage");
	}

	@When("User Search For Pune in search bar")
	public void user_search_for_pune_in_search_bar() {
	    fp.enter_city_name();
	    fp.click_search_button();
	    ApplicationHooks.scn.log("User Search For Pune in search bar");
	}

	@Then("User Get the information of Pune weather")
	public void user_get_the_information_of_pune_weather() {
	    boolean actual = fp.Pune_searched_text_is_displayed();
	    Assert.assertEquals(actual, true);
	    ApplicationHooks.scn.log("User Get the information of Pune weather");
	}
	
	
	/*
	 * 
	 * 
	 * TC2
	 * 
	 * 
	 */


	@Given("User Navigate to Homepage and search for Pune City")
	public void user_navigate_to_homepage_and_search_for_pune_city() {
		DriverFactory.getDriver().get("https://openweathermap.org/");
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    fp.enter_city_name();
	    fp.click_search_button();
	    ApplicationHooks.scn.log("User Navigate to Homepage and search for Pune City");
	}

	@When("User Navigate to Correctness weather details")
	public void user_navigate_to_correctness_weather_details() {
		fp.click_Pune();
		ApplicationHooks.scn.log("User Navigate to Correctness weather details");
	    
	    
	}

	@Then("Validate visibility and correctness of weather details once a Pune weather data")
	public void validate_visibility_and_correctness_of_weather_details_once_a_pune_weather_data() {
		
	    fp.weather_data_is_displayed();
	    ApplicationHooks.scn.log("User Navigate to Correctness weather details and Humidity ,DewPoint,UV,Visibility is displayed");
	    
	}
	
	/*
	 * 
	 * 
	 * TC3
	 * 
	 * 
	 */


	@When("User Clicks on Location icon and Navigates to Your City")
	public void user_clicks_on_location_icon_and_navigates_to_your_city() {
	    fp.click_location_icon();
	    ApplicationHooks.scn.log("User Clicks on Location icon and Navigates to Your City");
	    
	}

	@Then("Validate your city name is {string}")
	public void validate_your_city_name_is(String string) {
		String Cityname = fp.get_cityname();
		 Assert.assertEquals(Cityname, string);
	
		ApplicationHooks.scn.log("City Name is Validated by Pune Location");
		 
	    
	    
	}
	
	/*
	 * 
	 * 
	 * TC4
	 * 
	 * 
	 */


	@When("User Search For {string} in search bar")
	public void user_search_for_in_search_bar(String string) {
		fp.search_city__searchbar(string); 
		ApplicationHooks.scn.log("User Search For xyz in search bar");
	    
	}

	@Then("Validate that user get No Result Response")
	public void validate_that_user_get_no_result_response() {
	    boolean actual = fp.get_no_result_response();
	    Assert.assertEquals(actual, true);
	    ApplicationHooks.scn.log("User get No Result Response");
	}

	/*
	 * 
	 * 
	 * TC5
	 * 
	 * 
	 */

	@Given("User Navigate to Map Section")
	public void user_navigate_to_map_section() {
DriverFactory.getDriver().get("https://openweathermap.org/");
	    
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    fp.click_Maps();
	    ApplicationHooks.scn.log("User Navigate to Map Section");
	}

	@When("User Clicks on Different layers like global precipitation clouds wind speed temperature pressure")
	public void user_clicks_on_different_layers_like_global_precipitation_clouds_wind_speed_temperature_pressure() {
		fp.clickGlobal_precipation();
		fp.click_clouds();
		fp.click_WindSpeed();
		fp.click_temperature();
		fp.click_pressure();
		  ApplicationHooks.scn.log("User Clicks on Different layers like global precipitation clouds wind speed temperature pressure");
	}

	@Then("Validate global precipitation clouds wind speed temperature pressure toggled and Viewed")
	public void validate_global_precipitation_clouds_wind_speed_temperature_pressure_toggled_and_viewed() {
		fp.Global_precipationis_toggledandViewed();
		fp.clouds_toggledandViewed();
		fp.WindSpeed_toggledandViewed();
		fp.temperature_toggledandViewed();
		fp.pressure_toggledandViewed();
		
		 ApplicationHooks.scn.log("Global precipitation clouds wind speed temperature pressure toggled and Viewed");
	    
	}
	
	
}
