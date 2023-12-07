@E2E
Feature: Authentication Feature

  Scenario Outline: Verify authentication endpoint
    Given basic authentication credentials are provided
    And the header "<HeaderKey>" is set to "<HeaderValue>"
    And the request should contain payload
    When a POST request is made to the endpoint
    Then the response status code should be 200
    And an authentication token should be returned

    Examples:
      | HeaderKey        | HeaderValue       |
      | Content-Type     | application/json  |