@Login
Feature: Login Functionality

  Background: 
    Given I am on the login page

  Scenario Outline: Login with valid credentials
    When I enter username "<username>" and password "<password>"
    Then I should see success message "Demo user"

    Examples: 
      | username | password |
      | demo     |     1234 |

  Scenario Outline: Login with invalid credentials
    When I enter username "<username>" and password "<password>"
    Then I should see error message "The given name / password are incorrect. Please, try again."

    Examples: 
      | username | password |
      | zod      | krypton  |
