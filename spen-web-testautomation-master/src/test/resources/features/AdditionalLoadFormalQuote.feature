@AdditionalLoad @AdditionalLoadFormalQuote @dev @test @prod
@Issue #SPFD-1025
Feature: Additional Load Formal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression @firefox
  Scenario Outline: Additional Load Formal quote - Customer is payee and site contact
    Given I select "Additional Load" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I provide the additional load details: "<property>", "<heating>", "<mpan>", "<max_load>", "<phase>"
    And I select other significant loads: "<other_loads>"
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Additional Load" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                                            | postcode | county         | works  | email        | password   | property            | heating                  | mpan          | max_load | phase        | other_loads                                 | contact | info                                   |
      | I would like to alter my capacity agreement                       | EH6 4NQ  | Edinburgh      | SPEN   | [user_email] | [password] | House               | Electric Central Heating | 1312345678901 | 10       | Single phase | Welding Equipment                           | Phone   | Add Load Formal - SPEN to excavate     |
      | Increase the capacity of my connection from single to three phase | KA11 4DQ | South Ayrshire | I will | [user_email] | [password] | Commercial Premises | Gas, Oil or No heating   | 1812345678901 | 789      | Three phase  | Large Electrical Motors, 3-Phase EV Charger | Email   | Add Load Formal - Customer to excavate |


  @regression
  Scenario Outline: Additional Load Formal quote - Contractor is paying
    Given I select "Additional Load" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I enter the applicant details:
      | title | first_name | last_name | business_name                     | mobile      | landline    | email                      |
      | Rev   | Mary       | Davidson  | Auto Test Applicant Business Name | 07774443333 | 01115555999 | auto_testing@hotmail.co.uk |
    And I select No to site address same as applicant address
    And I enter the applicant address postcode "<applicant_postcode>"
    And I select county "<applicant_county>"
    And I select No to paying for work
    And I enter payment contact details:
      | title | first_name | last_name | mobile      | landline    | email                          | postcode | county            |
      | Dr    | George     | Richard   | 07774445555 | 01413333888 | george.richard@contractors.com | G77 5LH  | East Renfrewshire |
    And I select Yes to company paying and enter company details:
      | company_name      | vat_num    | company_num |
      | Test Builders Ltd | GB12345678 | SC123456    |
    And I select No to site contact
    And I enter site contact details:
      | title | first_name | last_name | position     | mobile      | landline    | email                       |
      | Miss  | Sandra     | Johnson   | Site Manager | 07775555666 | 01217779999 | sandra_johnson@builders.com |
    And I provide the additional load details: "<property>", "<heating>", "<mpan>", "<max_load>", "<phase>"
    And I select other significant loads: "<other_loads>"
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Additional Load" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                 | postcode | county         | works  | email        | password   | applicant_postcode | applicant_county  | property            | heating                         | mpan          | max_load | phase       | other_loads                                                                          | contact | info                                |
      | Increase the capacity of my connection | KA11 4DQ | South Ayrshire | I will | [user_email] | [password] | KA11 4DQ           | South Ayrshire    | Commercial Premises | Ground / Water Source Heat Pump | 1823456789012 | 895      | Three phase | Swimming Pool, Welding Equipment, Large Electrical Motors, 3-Phase EV Charger, Other | Email   | Add Load Formal - Contractor paying |
