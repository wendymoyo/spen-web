@Diversion @DiversionInformalQuote @dev @test @prod @firefox
@Issue #SPFD-1030
Feature: Diversion Informal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Diversion Informal quote - Customer is payee and site contact
    Given I select "Diversion" application
    And I select "Moving underground cables or overhead powerlines" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
#    When I enter the site address and postcode "<postcode>" manually
#    And I select county "<county>"
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Diversion" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | postcode | county            | works  | contact | info                                      |
      | [user_email] | [password] | EH6 4NQ  | Edinburgh         | SPEN   | Post    | Diversion Informal - SPEN to excavate     |
      | [user_email] | [password] | G72 7DE  | South Lanarkshire | I will | Phone   | Diversion Informal - Customer to excavate |


  @regression
  Scenario Outline: Diversion - Edit Quote type and Excavation details from App Review page
    Given I select "Diversion" application
    And I select "Moving underground cables or overhead powerlines" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details
    And I click Back button to Quote type page
    And I select Formal quote type
    And I select "<works_edit>" to dig private land
    And I continue to Application Review page
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Diversion" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | postcode | county         | works  | works_edit | contact | info                                       |
      | [user_email] | [password] | KA11 4DQ | South Ayrshire | I will | SPEN       | Email   | Diversion - Edit quote type and excavation |
