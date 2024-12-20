#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Guest User in Amazon
  I want to be a Guest User and check the functionality

  @tag1
  Scenario: View the product as a Guest User
    Given I am on the Amazon Homepage
    When Enter "Smart Watch" in the search bar
    Then View the details of the Smart watch

  @tag2
  Scenario Outline: Add to cart as a Guest User
    Given I am on the Amazon Homepage
    When Enter "<Product>" in the search bar
    And Add "<Product>" to the cart
    Then Check whether "<Product>" is added to the cart

  @tag3
  Scenario: Remove the product from the Guest User cart
    Given I am on the Amazon Homepage
    When Enter "Smart Watch" in the search bar
    And Remove the "Smart Watch" from the cart
    Then Check whether it is removed from the Guest User Account

  @tag4
  Scenario: Save it later option
    Given I am on the Amazon Homepage
    When Enter "Smart Watch" in the search bar
    And Click the "Save it Later" option
    Then Buy it later

  @tag5
  Scenario: Again view the account after some time
    Given I am on the Amazon Homepage
    When Enter "Smart Watch" in the search bar
    And View again the Amazon homepage
    Then There is Nothing in the cart

  Examples:
    | Product     | status  |
    | Smart Watch | success |
    | Headphones  | fail    |
