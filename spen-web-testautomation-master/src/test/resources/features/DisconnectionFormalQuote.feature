@Disconnections @DisconnectionFormalQuote @dev @test @prod
Feature: Disconnection Formal Quote journey tests

  Background:
    Given the user is on the change connection page

  @Issue #SPFD-1024
  @smoke @regression
  Scenario Outline: Disconnection Formal Quote - Customer is payee and site contact
    Given I select "Disconnection" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
#    When I enter the site address and postcode "<postcode>" manually
#    And I select county "<county>"
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select "1-3" disconnections
    And I provide the Disconnection plot details:
      | plot | mpan   | site_address   | vacant   |
      | 1    | <mpan> | <site_address> | <vacant> |
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Disconnection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                              | postcode | county    | email        | password   | works  | mpan          | site_address | vacant | contact | info                                        |
      | Disconnect a single standard supply | EH6 4JG  | Edinburgh | [user_email] | [password] | I will | 1812345678901 | Yes          | Yes    | Email   | Disconnection Formal - Customer to excavate |


  @Issue #SPFD-1187
  @regression @firefox
  Scenario Outline: Disconnection Formal Quote - Three connection plots
    Given I select "Disconnection" application
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
    And I select "1-3" disconnections
    And I provide the Disconnection plot details:
      | plot | mpan          | site_address | site_postcode | county       | vacant |
      | 1    | 1812345678901 | Yes          | N/A           | N/A          | Yes    |
      | 2    | 1323456789012 | No           | PA1 2QR       | Renfrewshire | No     |
      | 3    | 1834567890123 | Yes          | N/A           | N/A          | No     |
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Disconnection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                | postcode | county    | email        | password   | works | contact | info                                        |
      | Disconnect multiple standard supplies | EH6 4NQ  | Edinburgh | [user_email] | [password] | SPEN  | Phone   | Disconnection Formal - Three disconnections |

  @Issue #SPFD-1185
  @regression
  Scenario Outline: Disconnection Formal Quote - Contractor paying and upload spreadsheet
    Given I select "Disconnection" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
#    When I enter the site address and postcode "<postcode>" manually
#    And I select county "<county>"
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I enter the applicant details:
      | title | first_name | last_name | business_name                     | mobile      | landline    | email                    |
      | Mr    | Daniel     | Reynolds  | Auto Test Applicant Business Name | 07774443333 | 01318877665 | danielreynolds@gmail.com |
    And I select No to site address same as applicant address
    And I enter the applicant address postcode "<applicant_postcode>"
    And I select county "<applicant_county>"
    And I select No to paying for work
    And I enter payment contact details:
      | title | first_name | last_name | mobile      | landline    | email                      | postcode | county    |
      | Rev   | James      | Bond      | 07766555444 | 01214433999 | jamesbond007@hotmail.co.uk | EH6 4NQ  | Edinburgh |
    And I select Yes to company paying and enter company details:
      | company_name        | vat_num    | company_num |
      | BGC Contracting Ltd | GB23456789 | SC234567    |
    And I select No to site contact
    And I enter site contact details:
      | title | first_name | last_name | position  | mobile      | landline    | email                        |
      | Ms    | Claudia    | Williams  | Secretary | 07775555666 | 01217779999 | claudia.williams@yahoo.co.uk |
    And I select "4 or more" disconnections
    And I upload a Disconnections spreadsheet
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Disconnection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                           | postcode | county         | email        | password   | works | applicant_postcode | applicant_county  | contact | info                                      |
      | Disconnect a high-voltage supply | KA1 1ED  | South Ayrshire | [user_email] | [password] | SPEN  | G77 5LH            | East Renfrewshire | Post    | Disconnection Formal - Upload spreadsheet |
