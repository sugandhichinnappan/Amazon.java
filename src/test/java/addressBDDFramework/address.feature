@tag
Feature: Amazon Address functionality
  I want to Add Address, Add Additional Delivery Instructions, Set Default Address, 
  and Suggest the correct address when invalid details are entered.

  @tag1
  Scenario: Add address functionality
    Given I am on the Amazon homepage
    And I am logged into my Amazon account
    When I click the "Your Address" option
    And I click on "Add Address" option
    And I enter the address details
    Then I save the address

  @tag2
  Scenario Outline: Additional Delivery Instruction functionality
    Given I am logged into my Amazon account
    When I click on the "Additional Delivery Instructions" option
    And I enter the delivery details
    Then I save the address

    Examples:
      | Instruction  | Expected Result       |
      | Leave with neighbor | Save the delivery instruction |
      | Ring bell twice    | Save the delivery instruction |

  @tag3
  Scenario: Default Address functionality
    Given I am logged into my Amazon account
    When I click on the "Default Address" option
    And I enter the address details
    Then I save the address as the default address

  @tag4
  Scenario: Suggestion Address functionality
    Given I am logged into my Amazon account
    When I click on the "Add Address" section
    And I enter the invalid address details
    Then I am prompted with a suggestion for the correct address
    And I save the corrected address