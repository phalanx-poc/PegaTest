Feature: Pega Test

  @Pass
  Scenario: Pass Test
    Given User launches the application url
    When User enters valid login credentials
    Then User should be able to login to the application

    @Fail
  Scenario: Fail Test
    Given User launches the application url
    When User enters invalid login credentials
    Then User should be able to login to the application