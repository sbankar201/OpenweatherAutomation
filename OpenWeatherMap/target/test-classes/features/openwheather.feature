Feature: openwheather

  Scenario: Searching for weather information of a Pune city
    Given User Navigate to Homepage
    When User Search For Pune in search bar
    Then User Get the information of Pune weather



  Scenario: Test the  visibility and correctness of weather details once a Pune weather
             data is displayed
    Given User Navigate to Homepage and search for Pune City
    When User Navigate to Correctness weather details
    Then Validate visibility and correctness of weather details once a Pune weather data


  Scenario: Test the navigation to the "Weather in your city" section and verify its
    functionalities.

    Given User Navigate to Homepage
    When User Clicks on Location icon and Navigates to Your City
    Then Validate your city name is "Pune, IN"

  Scenario: Test the response when trying to search for an invalid city name
    Given User Navigate to Homepage
    When User Search For "xyz" in search bar
    Then Validate that user get No Result Response

  Scenario: Navigate to the Maps section and ensure different layers like Precipitation pressure Temp
    Wind speed can be toggled and viewed
    Given User Navigate to Map Section
    When User Clicks on Different layers like global precipitation clouds wind speed temperature pressure
    Then Validate global precipitation clouds wind speed temperature pressure toggled and Viewed
    