@E2E
Feature: Booking IDs Retrieval Feature

  Scenario Outline: Retrieve Booking IDs and Write to JSON
    When the header is  "<HeaderKey>" is set to "<HeaderValue>"
    And a GET request is made to the booking endpoint
    Then the response status code should be 200
    And the response should contain booking information written to a JSON file

    Examples:
      | HeaderKey | HeaderValue      |
      | accept    | application/json |
