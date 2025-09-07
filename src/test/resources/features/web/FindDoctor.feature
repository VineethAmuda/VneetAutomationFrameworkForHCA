Feature: Find a Doctor functionality

  @Regression
  Scenario: Verify Find a Doctor search
    Given User is on HCA Healthcare home page
    When User clicks on "Find a Doctor"
    And User enters "Cardiology" in search box
    And User clicks Search button
    Then Results should be displayed
