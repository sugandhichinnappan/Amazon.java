@tag
Feature: Payment Functionality in Amazon
  As a customer, I want to verify the payment option

@tag1
Scenario: Check Add Payment option
   Given I am in the Amazon page
   And I logged in to the Amazon Account
   When I click on the "ADD Payment" option
   And Save the credit card
   Then Check whether the Credit card is saved

@tag2
Scenario Outline: Check default Payment option
   Given I am in the Amazon Page
   And I logged in to the Amazon Account
   When I click on the "Default Payment" option
   And Save the option
   Then Check whether the default payment is selected during checkout
   Examples:
     | name  | value | status  |
     | name1 |     5 | success |
     | name2 |     7 | fail    |
