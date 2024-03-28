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
Feature: Purchase the order from the ecommerce website
  I want to use this template for my feature file
	
	Background:
	Given I landed on ecommerce website
  @submitOrder
  Scenario: Positive test for submitting the order
    Given logged in with username <username> and password <password>
    When I have added the product <product> to cart
    And checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page
    Examples: 
      | username        | password | product      |
      | testD@gmail.com | Test@123 | ZARA COAT 3  |
