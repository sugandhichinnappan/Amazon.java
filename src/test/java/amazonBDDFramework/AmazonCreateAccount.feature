@CreateAccount
Feature: Amazon Create Account
  As a User, I want to create an account on Amazon to shop and manage my orders.

  Scenario: Click the Start Here Link
    Given User is on the Amazon Create Account Page
    When User clicks on the "Start Here" link
    Then User should be redirected below the Sign-In section

  Scenario: Create Account with details
    Given User is on the Amazon Create Account Page
    When User clicks on the "Start Here" link below Sign-in
    And User enters name, email, and mobile number
    Then User should be redirected to the password field

  @tag2
  Scenario: Create Account with Details and Password
    Given User is on the Amazon Create Account Page
    When User clicks on the "Start Here" link below Sign-in
    And User enters name, email, and mobile number
    And User enters password
    Then User should be redirected to the "Re-enter Password" field

  @tag3
  Scenario: Create Account with details and Check Password
    Given User is on the Amazon Create Account Page
    When User clicks on the "Start Here" link below Sign-in
    And User enters name, email, and mobile number
    And User enters password
    And User enters a matching "Re-enter Password"
    Then User clicks on Continue and should verify the email confirmation

  @tag4
  Scenario: Sign-in with valid details
    Given User is on the Amazon Sign-In page
    When User enters valid email and password
    And User clicks the Sign-In button
    Then User should be successfully signed in and redirected to the home page

  @tag5
  Scenario: Sign-in with "Keep me signed in" checkbox
    Given User is on the Amazon Sign-In page
    When User enters valid email and password
    And User selects the "Keep me signed in" checkbox
    And User clicks the Sign-In button
    Then User should be signed in without needing to enter credentials again

  @tag6
  Scenario: Greeting message display after sign-in
    Given User is on the Amazon Sign-In page
    When User enters valid email and password
    And User clicks the Sign-In button
    Then User should see a greeting message like "Hello, [User Name]"
