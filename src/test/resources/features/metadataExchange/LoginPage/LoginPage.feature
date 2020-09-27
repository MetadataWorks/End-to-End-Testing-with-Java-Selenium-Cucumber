@SmokeTest
Feature: LoginPage

  I can login into the application with only valid credentials

  Background: I can access the login page
    Given The browser window is open
    And I am on the login page
    And Login page header is displayed


  Scenario: I can login to the application with valid credentials
    When I enter valid username
    And I enter valid password
    And I click on the login button
    Then I am logged into the application
    And The Welcome Page is displayed

  Scenario: I can not login to the application with invalid username
    When I enter invalid username
    And I enter valid password
    And I click on the login button
    Then Unauthorised Access error message is displayed

  Scenario: I can not login to the application with invalid password
    When I enter valid username
    And I enter invalid password
    And I click on the login button
    Then Unauthorised Access error message is displayed