Feature: Invalid search validation

  @Regression
  Scenario: Verify invalid doctor search
    Given User is on HCA Healthcare home page
    When User clicks on "Find a Doctor"
    And User enters "ZZZZZZ" in search box
    And User clicks Search button
    Then No results should be displayed
