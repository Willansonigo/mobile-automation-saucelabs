# language: en
Feature: Login functionality on a mobile app
  As a mobile app user
  I want to log in to the app
  So that I can access my account

  Background:
    Given the app is launched

  Scenario: Successful login with valid credentials
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    Then I should see the home screen

  Scenario: Login attempt with invalid credentials
    When I enter an invalid username "invalid_user"
    And I enter an invalid password "wrong_password"
    And I tap on the login button
    Then I should see an error message "Username and password do not match any user in this service."

  Scenario: Login attempt with empty fields
    When I leave the username field empty
    And I leave the password field empty
    And I tap on the login button
    Then I should see an error message with empty fields "Username is required"

  Scenario: login with locked_out_user
    When I enter a valid username "locked_out_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    Then I should see an error message for locked user "Sorry, this user has been locked out."

  Scenario: Successful login with a problem_user
    When I enter a valid username "problem_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    Then I should see the home screen

