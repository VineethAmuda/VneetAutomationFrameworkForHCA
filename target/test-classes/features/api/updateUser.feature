Feature: Update existing user in ReqRes API

  @APITest @Regression
  Scenario: Update user job title
    Given I set the API endpoint for user with id "2"
    When I send a PUT request with job "Senior QA Engineer"
    Then The response status should be 200
    And The response should contain job "Senior QA Engineer"
