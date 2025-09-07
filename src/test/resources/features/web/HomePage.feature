Feature: Validate HCA Healthcare Home Page

  @Smoke
  Scenario: Verify home page loads successfully
    Given User launches the browser
    When User navigates to HCA Healthcare home page
    Then Home page title should be "HCA Healthcare - Find a Doctor, Location and Services"
