# language: en
Feature: Shopping functionality on a mobile app
  As a mobile app user
  I want to browse and purchase items
  So that I can complete my shopping

  Background:
    Given the app is launched

  Scenario: Complete a purchase
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I select a product "Sauce Labs Backpack"
    And I add the product to the cart
    And I have items in my cart
    And I proceed to checkout
    And I enter my shipping information
    When I confirm the purchase
    Then I should see a confirmation message "THANK YOU FOR YOU ORDER"
    And I tap in back home button

  Scenario: Testing the type view products button
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I tap on the Type View Products button
    And I add the product to the cart using plus button
    Then I have items in my cart

  Scenario: Testing searching for products using filters
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    Then I using filters to search for products

  Scenario: Add all products to the cart
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I add all the products to the cart
    Then I have items in my cart

  Scenario: Selecting products and backing to home
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I select a product "Sauce Labs Backpack"
    And I tap in back to products button
    Then I should see the home screen

  Scenario: Removing the product
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I select a product "Sauce Labs Backpack"
    And I add the product to the cart
    And I have items in my cart
    And I tap in remove product
    When I tap in continue shopping
    Then I should see the home screen

  Scenario: Cancel the checkout
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I select a product "Sauce Labs Backpack"
    And I add the product to the cart
    And I have items in my cart
    And I proceed to checkout
    When I cancel checkout
    Then I should see the home screen

  Scenario: Cancel the purchase
    When I enter a valid username "standard_user"
    And I enter a valid password "secret_sauce"
    And I tap on the login button
    And I select a product "Sauce Labs Backpack"
    And I add the product to the cart
    And I have items in my cart
    And I proceed to checkout
    And I enter my shipping information
    When I cancel the purchase
    Then I should see the home screen
