Feature: User sing up feature as an unregister user i should be able to sing up using singup page

  Background:
    Given I am on the home page

@ui-test
  Scenario: Non registered user singup positive

    When I navigate to singup page and enter valid credentials.
    Then I should be able to sing up successfully

