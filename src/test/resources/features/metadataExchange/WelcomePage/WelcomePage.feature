Feature: WelcomePage

  I can access Welcome Page when I am logged into the application

  @SmokeTest @HappyPath
  Scenario: When I log into the application Welcome Page is displayed
    When I log into the application
    Then The Welcome Page is displayed
