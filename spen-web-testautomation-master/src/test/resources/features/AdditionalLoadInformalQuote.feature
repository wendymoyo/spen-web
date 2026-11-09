@AdditionalLoad @AdditionalLoadInformalQuote @dev @test @prod @firefox
@Issue #SPFD-1032
Feature: Additional Load Informal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Additional Load Informal quote - Customer is payee and site contact
    Given I select "Additional Load" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I provide the additional load details: "<property>", "<heating>", "<mpan>", "<max_load>", "<phase>"
    And I select other significant loads: "<other_loads>"
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Additional Load" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                 | postcode | county            | works  | email        | password   | property | heating                  | mpan          | max_load | phase        | other_loads       | contact | info                                      |
      | Increase the capacity of my connection | ML3 7SP  | North Lanarkshire | I will | [user_email] | [password] | House    | Electric Central Heating | 1312345678901 | 10       | Single phase | Welding Equipment | Phone   |  Add Load Informal - Customer to excavate |


  @regression
  Scenario Outline: Additional Load - Edit Quote type and Excavation details from App Review page
    Given I select "Additional Load" application
    And I select "<option>" change connection option
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
    And I provide the additional load details: "<property>", "<heating>", "<mpan>", "<max_load>", "<phase>"
    And I select other significant loads: "<other_loads>"
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
    And I am taken to the "Additional Load" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                      | postcode | county            | works  | works_edit | email        | password   | property | heating                  | mpan          | max_load | phase        | other_loads       | contact | info                                       |
      | I would like to alter my capacity agreement | ML3 7SP  | North Lanarkshire | I will | SPEN       | [user_email] | [password] | House    | Electric Central Heating | 1312345678901 | 10       | Single phase | Welding Equipment | Phone   |  Add Load - Edit quote type and excavation |

