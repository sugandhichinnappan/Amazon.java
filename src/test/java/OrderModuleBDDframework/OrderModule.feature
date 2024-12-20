@tag
Feature: Order Module on Amazon
  As a customer,
  I want to place an order and go to my order history,
  So that I can track and manage my orders on Amazon.

  @tag1
  Scenario: Check the "Your Order" Section
    Given I am logged into my Amazon account at "https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs"
    When I click on the "Start Here" link
    And I enter the email "techsugandhi@gmail.com" and password "amazon123"
    And I click on the "Sign-in" button
    Then I should be on the Amazon Homepage
    And I should see the "Your Order" option
    And I can view the orders placed in the last 3 months

  @tag2
  Scenario: Amazon Buy Again Option
    Given I am signed in on Amazon at "https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs"
    When I click on the "Sign-in" button
    And I enter the email "techsugandhi@gmail.com" and password "amazon123"
    Then I should be logged in to the Amazon homepage
    When I go to the "Your Order" section
    And I click on the "Buy Again" link
    Then I should see the products purchased last year

  @tag3
  Scenario: Amazon Cancelled Order Functionality
    Given I am signed in on Amazon at "https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs"
    When I enter the email "techsugandhi@gmail.com" and password "amazon123"
    Then I should be logged in to the Amazon homepage
    When I go to the "Your Order" section
    And I click on the "Cancelled Orders" link
    Then I should see the products cancelled last year

  @tag4
  Scenario: Amazon "Not Yet Shipped" Functionality
    Given I am signed in on Amazon at "https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs"
    When I enter the email "techsugandhi@gmail.com" and password "amazon123"
    Then I should be logged in to the Amazon homepage
    When I go to the "Your Order" section
    And I click on the "Not Yet Shipped" link
    Then I should see the products that are ready to be shipped

    Examples:
      | name   | value | status  |
      | name1  | 5     | success |
      | name2  | 7     | fail    |