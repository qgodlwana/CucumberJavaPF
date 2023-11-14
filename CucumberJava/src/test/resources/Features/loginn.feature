Feature: login functionality

  Scenario Outline: check login with valid credentials
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username  | password |
      | Qaqambile |    12345 |
