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
Feature: Amazon Search functionality
  I want to Search for Product 

  @tag1
  Scenario: Search for a Product
    Given I am on the Amazon homepage 
    And I am loggin into my Account
    When Enter "Tablet" in the search bar
    
    And I Click on the search icon
   
    Then I Should see search results for "Tablet"

  @tag2
  Scenario Outline: Search for a product with "filters"
    Given I am on the Amazon homepage
    When Enter "T-shirt" in the search bar
    And click on the "Filter" option
    And click "Women" and "M size"
    Then Show the Women tshirt with M size
     @tag3
  Scenario Outline: Search for a product with "Sorting"
    Given I am on the Amazon homepage
    When Enter "T-shirt" in the search bar
    And click on the "Sort" option
    And click "Low to High " option
    
    @tag4 
    Scenario: Search for a "Pagination" functionality
       Given I am on the Amazon homepage
    When Enter "T-shirt" in the search bar
    And Click on the "Next" button
    Then Item on the page 2 should not repeat from page

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
