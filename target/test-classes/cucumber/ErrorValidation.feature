
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @errroValidation
  Scenario: Negative Test for error validation
  	Given I landed on ecommerce website
    When logged in with username <username> and password <password>
    Then "Incorrect email or password." error message is displayed
    Examples: 
      | username       | password |
      | testD@gmal.com | Test@123 |
