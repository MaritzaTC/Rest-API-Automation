Feature: Create user
  As a new user
  I want to register in the system
  To create an account

  Scenario: Create a new user
    Given I have access to the system
    When I create a new user
    Then I should see a satisfactory state

  Scenario: Retrieve a user
    Given I have access to the system
    When I validate get response contain data expected
    Then I retrieve a user state

  Scenario: Delete user
    Given I have access to the system
    When I delete a user
    Then I should see a successful deletion status




