Feature: Careers page navigation

  @Regression
  Scenario: Verify Careers page link
    Given User is on HCA Healthcare home page
    When User clicks on "Careers"
    Then Careers page should open
