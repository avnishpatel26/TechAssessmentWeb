@WebAutomation
Feature: Login Action
  Description: This feature will test a login functionality

  Background: 
    Given User navigates to Login page

  @Login
  Scenario: Login with valid credentials
    And user enters username with "john.smith@gmail.com"
    And user enters password with "john"
    And user clicks on Login button
    Then user should logged in successfully

  @Login
  Scenario: Login with invalid credentials
    And user clicks on Login button
    Then user should not be logged in and gets a validation message "Please enter your e-mail"
    And user enters username with "john.smith@gmail.com"
    And user enters password with "john1"
    And user clicks on Login button
    Then user should not be logged in and gets a validation message "Could not log in user: Internal Error"
    And user enters username with "john1.smith@gmail.com"
    And user enters password with "john123"
    And user clicks on Login button
    Then user should not be logged in and gets a validation message "Incorrect password, please try again"

  @AutoQuote
  Scenario: Apply For Auto Quote service
    And user selects service as "Auto Quote"
    Then user should be on Automobile Instant Quote Page
    And user enters Zip Code as "2976", E-mail as "Andy@gmail.com" and select Automobile Type as "car"
    And user clicks on Next button
    And user enters Age as "26", select Geneder as "Female" and Driving Record as "Good"
    And user clicks on Next button
    And user enters Year as "3", select Make as "Toyota", Model as "Camry" and Financial Info as "Finance"
    And user clicks on Next button
    Then quote should be created successfully

  @ContactUs
  Scenario: Validate Contact Us functionality
    And user clicks on Contact Us link
    Then user should be on contact us page
    And user fills all the details
      | Title | FirstName | LastName | Address | City | State | ZipCode | Telephone | Email          | Comment    |
      | Mr    | Andy      | Bury     | London  | CA   | state |    1034 |  27876545 | Andy@gmail.com | NoComments |
    And user clicks on submit button
    Then user should be on Home Page
