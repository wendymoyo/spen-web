@Diversion @DiversionFormalQuote @dev @test @prod
Feature: Diversion Formal Quote journey tests

  Background:
    Given the user is on the change connection page


  @Issue #SPFD-1012
  @smoke @regression @firefox @wendy
  Scenario Outline: Diversion Formal quote - Customer is payee and site contact
    Given I select "Diversion" application
    And I select "Moving underground cables or overhead powerlines" change connection option
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
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Diversion" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | postcode | county            | works  | contact | info                                    |
      | [user_email] | [password] | G72 7DE  | South Lanarkshire | I will | Phone   | Diversion Formal - Customer to excavate |
      | [user_email] | [password] | ML3 7SP  | North Lanarkshire | SPEN   | Phone   | Diversion Formal SPEN to excavate       |


  @Issue #SPFD-1012
  @regression
  Scenario Outline: Diversion Formal quote - Contractor is paying
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
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I enter the applicant details:
      | title | first_name | last_name | business_name                     | mobile      | landline    | email                      |
      | Dr    | Mary       | Davidson  | Auto Test Applicant Business Name | 07774443333 | 01115555999 | auto_testing@hotmail.co.uk |
    And I select No to site address same as applicant address
    And I enter the applicant address postcode "<applicant_postcode>"
    And I select county "<applicant_county>"
    And I select No to paying for work
    And I enter payment contact details:
     | title | first_name | last_name | mobile      | landline    | email                          | postcode | county            |
     | Mr    | George     | Richard   | 07774445555 | 01413333888 | george.richard@contractors.com | G77 5LH  | East Renfrewshire |
    And I select Yes to company paying and enter company details:
     | company_name      | vat_num    | company_num |
     | Test Builders Ltd | GB12345678 | SC123456    |
    And I select No to site contact
    And I enter site contact details:
      | title | first_name | last_name | position     | mobile      | landline    | email                       |
      | Mrs   | Sandra     | Johnson   | Site Manager | 07775555666 | 01217779999 | sandra_johnson@builders.com |
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Diversion" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | postcode | county         | works | applicant_postcode | applicant_county | contact | info                                 |
      | [user_email] | [password] | KA11 4DQ | South Ayrshire | SPEN  | G40 1LR            | Glasgow          | Phone   | Diversion Formal - Contractor paying |


  @Issue #SPFD-1195
  @wip @firefox # Need Devs to disable recaptcha first
  Scenario Outline: Diversion Formal quote - Customer registers during app
    Given I select "Diversion" application
    And I select "Moving underground cables or overhead powerlines" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I click "Register now" link
    And I enter customer details:
      | title | first_name | last_name | company_name                     | mobile      | landline    | email                         | password   |
      | Miss  | Tracy      | Reynolds  | Auto Test Applicant Company Name | 07776655444 | 02034455888 | tracy-reynolds123@outlook.com | [password] |
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
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Diversion" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | county         | works  | contact | info                                         |
      | KA11 4DQ | South Ayrshire | I will | Phone   | Diversion Formal - Customer registers in app |
