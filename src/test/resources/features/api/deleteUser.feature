Feature: Delete a user from ReqRes API

  @APITest @Regression
  Scenario: Delete user by ID
    Given I set the API endpoint for user with id "2"
    When I send a DELETE request
    Then The response status should be 204
