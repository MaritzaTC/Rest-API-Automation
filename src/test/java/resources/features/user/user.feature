Feature: Create user
  As a new user
  I want to register in the system
  To create an account

  Scenario: Create a new user
    Given I have access to the system
    When I create a new user
    Then Should see the code 201

  Scenario: Retrieve a user
    Given I have access to the system
    Then I retrieve a user
    And I validate get response contain data expected

  Scenario: Delete user
    Given I have access to the system
    When I delete a user
    Then Should see the code 204


