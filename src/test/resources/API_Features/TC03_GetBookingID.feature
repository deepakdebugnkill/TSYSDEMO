@E2E
Feature: Booking ID Retrieval Feature

  Scenario Outline: Retrieve a Booking ID
    When a GET request is made to the booking specific booking endpoint "<HeaderKey>" , "<HeaderValue>"
    Then the response status code should be 200
    And the response should contain single booking information

    Examples:
      | HeaderKey | HeaderValue      |
      | accept    | application/json |
