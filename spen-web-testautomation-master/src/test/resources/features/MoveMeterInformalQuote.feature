@MoveMeter @MoveMeterInformalQuote @dev @test @prod @firefox
Feature: Move Meter Informal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Move Meter Estimated Cost Informal quote - Customer is payee and site contact
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I enter the Move meter site address postcode "<postcode>"
    And I select an address not eligible for fixed price
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
#    And I select "Yes" to property being more than one meter from a public road
    And I am shown my Move Meter estimated quote
    And I request for an email of my estimated quote "<email>"
    And I accept the Move Meter terms and conditions
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Informal quote type
    And I select Yes to site address same as applicant address
    And I select meter type as "<meter>"
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | works  | email        | password   | property | meter          | distance | phase        | contact | info                                       |
      | EH6 4JG  | I will | [user_email] | [password] | House    | Standard Meter | 11       | Single phase | Phone   | Move Meter Informal - Customer to excavate |


  @regression
  Scenario Outline: Move Meter Informal quote - No Estimated Cost
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I enter the Move meter site address postcode "<postcode>"
    And I select an address not eligible for fixed price
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I am not shown an estimated quote
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Informal quote type
    And I select Yes to site address same as applicant address
    And I select meter type as "<meter>"
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | works | email        | password   | property         | meter       | distance | phase        | contact | info                                            |
      | EH6 4NQ  | N/A   | [user_email] | [password] | Flat / Apartment | Smart Meter | 23       | Single phase | Email   | Move Meter Flat Informal - Customer to excavate |


  @regression
  Scenario Outline: Move Meter No Estimated Cost - Edit Quote type from App Review page
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I enter the Move meter site address postcode "<postcode>"
    And I select an address not eligible for fixed price
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I am not shown an estimated quote
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Informal quote type
    And I select Yes to site address same as applicant address
    And I select meter type as "<meter>"
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details
    And I click Back button to Quote type page
    And I select Formal quote type
    And I continue to Application Review page
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | works  | email        | password   | property            | meter          | distance | phase        | contact | info                                    |
      | KA11 4DQ | I will | [user_email] | [password] | House               | Smart Meter    | 17       | Single phase | Post    | Move Meter House - Edit quote type      |
      | ML3 7SP  | SPEN   | [user_email] | [password] | Commercial Premises | Standard Meter | 25       | Three phase  | Email   | Move Meter Commercial - Edit quote type |
