Feature: Get user details from ReqRes API

  @APITest @Regression
  Scenario: Get single user by ID
    Given I set the API endpoint for user with id "2"
    When I send a GET request
    Then The response status should be 200
    And The response should contain first_name "Janet"
