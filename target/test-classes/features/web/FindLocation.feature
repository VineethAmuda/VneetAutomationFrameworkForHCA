Feature: Find a Location functionality

  @Regression
  Scenario: Verify Find a Location link
    Given User is on HCA Healthcare home page
    When User clicks on "Find a Location"
    Then User should be redirected to location page
