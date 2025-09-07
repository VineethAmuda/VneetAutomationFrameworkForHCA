Feature: Create a new user in ReqRes API

  @APITest @Regression
  Scenario: Create a new user
    Given I set the API endpoint for creating user
    When I send a POST request with name "Vineeth" and job "QA Engineer"
    Then The response status should be 201
    And The response should contain name "Vineeth"
