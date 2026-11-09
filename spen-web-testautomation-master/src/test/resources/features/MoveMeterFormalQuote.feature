@MoveMeter @MoveMeterFormalQuote @dev @test @prod
Feature: Move Meter Formal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Move Meter Fixed Price Formal quote - Customer is payee and site contact
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I select a fixed price eligible postcode "<postcode>" and address "<address>"
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I select "Yes" to property being more than one meter from a public road
    And I am shown my Move Meter fixed price estimate quote
    And I request for an email of my estimated quote "<email>"
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select meter type as "<meter>"
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | address                                 | works  | email        | password   | property | meter          | distance | phase        | contact | info                                                 |
      | L6 1LX   | 6 Upper Baker Street, Liverpool, L6 1LX | I will | [user_email] | [password] | House    | Standard Meter | 10       | Single phase | Phone   | Move Meter Fixed Price Formal - Customer to excavate |


  @regression @firefox
  Scenario Outline: Move Meter Fixed Price Formal quote - Contractor is paying
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I select a fixed price eligible postcode "<postcode>" and address "<address>"
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I select "Yes" to property being more than one meter from a public road
    And I am shown my Move Meter fixed price estimate quote
    And I request for an email of my estimated quote "<email>"
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I enter the applicant details:
      | title | first_name | last_name | business_name                     | mobile      | landline    | email                      |
      | Ms    | Mary       | Davidson  | Auto Test Applicant Business Name | 07774443333 | 01115555999 | auto_testing@hotmail.co.uk |
    And I select No to site address same as applicant address
    And I enter the applicant address postcode "<applicant_postcode>"
    And I select county "<applicant_county>"
    And I select No to paying for work
    And I enter payment contact details:
      | title | first_name | last_name | mobile      | landline    | email                          | postcode | county         |
      | Rev   | George     | Richard   | 07774445555 | 01413333888 | george.richard@contractors.com | KA11 4DQ | South Ayrshire |
    And I select Yes to company paying and enter company details:
      | company_name      | vat_num    | company_num |
      | Test Builders Ltd | GB12345678 | SC123456    |
    And I select No to site contact
    And I enter site contact details:
      | title | first_name | last_name | position     | mobile      | landline    | email                       |
      | Dr    | Sandra     | Johnson   | Site Manager | 07775555666 | 01217779999 | sandra_johnson@builders.com |
    And I select meter type as "<meter>"
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | address                                 | works  | email        | password   | property | meter       | distance | phase        | applicant_postcode | applicant_county | contact | info                                              |
      | L6 1LX   | 6 Upper Baker Street, Liverpool, L6 1LX | I will | [user_email] | [password] | House    | Smart Meter | 6        | Single phase | KA11 4DQ           | South Ayrshire   | Email   | Move Meter Fixed Price Formal - Contractor paying |

  @smoke @regression
  Scenario Outline: Move Meter Estimated Cost Formal quote - Customer is payee and site contact
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I enter the Move meter site address postcode "<postcode>"
    And I select an address not eligible for fixed price
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I am shown my Move Meter estimated quote
    And I request for an email of my estimated quote "<email>"
    And I accept the Move Meter terms and conditions
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Formal quote type
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select meter type as "<meter>"
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | works | email        | password   | property            | meter          | distance | phase        | contact | info                                                     |
      | EH6 4JG  | SPEN  | [user_email] | [password] | Commercial Premises | Standard Meter | 15       | Three phase  | Email   | Move Meter Estimated Price Commercial - SPEN to excavate |
      | EH6 4NQ  | SPEN  | [user_email] | [password] | House               | Smart Meter    | 9        | Three phase  | Phone   | Move Meter Estimated Price House - SPEN to excavate      |

  @smoke @regression @firefox
  Scenario Outline: Move Meter No Estimated Cost Formal quote - "<property>"
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
    And I select Formal quote type
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select meter type as "<meter>"
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | works  |  email       | password   | property            | meter          | distance | phase        | contact | info                                                      |
      | KA11 4DQ | N/A    | [user_email] | [password] | Flat / Apartment    | Standard Meter | 8        | Single phase | Phone   | Move Meter No Estimate Price Formal - Flat property       |
      | EH6 4JG  | I will | [user_email] | [password] | House               | Smart Meter    | 16       | Single phase | Post    | Move Meter No Estimate Price Formal - House property      |
      | G40 1LR  | I will | [user_email] | [password] | Commercial Premises | Smart Meter    | 25       | Three phase  | Email   | Move Meter No Estimate Price Formal - Commercial property |


  @regression @firefox
  Scenario Outline: Move Meter Fixed Price Eligible Formal quote - Estimated Cost
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I select a fixed price eligible postcode "<postcode>" and address "<address>"
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I am shown my Move Meter estimated quote
    And I request for an email of my estimated quote "<email>"
    And I accept the Move Meter terms and conditions
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Formal quote type
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select meter type as "<meter>"
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | address                           | works  | email        | password   | property | meter       | distance | phase        | contact | info                                             |
      | L6 9AJ   | 29 Ingrow Road, Liverpool, L6 9AJ | I will | [user_email] | [password] | House    | Smart Meter | 11       | Single phase | Post    | Move Meter Fixed Price Eligible - Estimated Cost |


  @regression
  Scenario Outline: Move Meter Fixed Price Eligible Formal quote - No Estimated Cost - House property less than 1m from public road
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I select a fixed price eligible postcode "<postcode>" and address "<address>"
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I select "No" to property being more than one meter from a public road
    And I am not shown an estimated quote
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Formal quote type
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select meter type as "<meter>"
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | address                           | works  | email        | password   | property | meter       | distance | phase        | contact | info                                                 |
      | L6 9AJ   | 29 Ingrow Road, Liverpool, L6 9AJ | I will | [user_email] | [password] | House    | Smart Meter | 2        | Single phase | Email    | Move Meter Fixed Price Eligible - No Estimated Cost |


  @regression @firefox
  Scenario Outline: Move Meter Estimated Cost Formal quote - Contractor is paying
    Given I select "Move Meter" application
    And I am shown the Moving a Meter Supply Position information page
    And I click Move Meter Apply Now button
    When I enter the Move meter site address postcode "<postcode>"
    And I select an address not eligible for fixed price
    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
    And I am shown my Move Meter estimated quote
    And I request for an email of my estimated quote "<email>"
    And I accept the Move Meter terms and conditions
    And I click Apply Now
    And I login using email "<email>" and password "<password>"
    And I continue to Move Meter application form
    And I select "No" to previous application question
    And I select Formal quote type
    And I enter the applicant details:
      | title | first_name | last_name | business_name                     | mobile      | landline    | email                      |
      | Ms    | Mary       | Davidson  | Auto Test Applicant Business Name | 07774443333 | 01115555999 | auto_testing@hotmail.co.uk |
    And I select No to site address same as applicant address
    And I enter the applicant address postcode "<applicant_postcode>"
    And I select county "<applicant_county>"
    And I select No to paying for work
    And I enter payment contact details:
      | title | first_name | last_name | mobile      | landline    | email                          | postcode | county         |
      | Rev   | George     | Richard   | 07774445555 | 01413333888 | george.richard@contractors.com | KA11 4DQ | South Ayrshire |
    And I select Yes to company paying and enter company details:
      | company_name      | vat_num    | company_num |
      | Test Builders Ltd | GB12345678 | SC123456    |
    And I select No to site contact
    And I enter site contact details:
      | title | first_name | last_name | position     | mobile      | landline    | email                       |
      | Dr    | Sandra     | Johnson   | Site Manager | 07775555666 | 01217779999 | sandra_johnson@builders.com |
    And I select meter type as "<meter>"
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Move Meter" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | postcode | works  | email        | password   | property            | meter          | distance | phase        | applicant_postcode | applicant_county  | contact | info                                                      |
      | EH6 4JG  | I will | [user_email] | [password] | Commercial Premises | Smart Meter    | 10       | Single phase | KA11 4DQ           | South Ayrshire    | Post    | Move Meter Estimated Price Commercial - Contractor paying |


#  @regression @wip
#  Scenario Outline: Move Meter Fixed Price Formal quote - Edit Functionality
#    Given I select "Move Meter" application
#    And I am shown the Moving a Meter Supply Position information page
#    And I click Move Meter Apply Now button
#    When I select a fixed price eligible postcode "<postcode>" and address "<address>"
#    And I provide the move meter supply position details: "<distance>", "<property>", "<phase>", "<works>"
#    And I select "Yes" to property being more than one meter from a public road
#    And I am shown my Move Meter fixed price estimate quote
#    And I request for an email of my estimated quote "<email>"
#    And I click Apply Now
#    And I login using email "<email>" and password "<password>"
#    And I continue to Move Meter application form
#    And I enter the applicant details:
#      | title | first_name | last_name | business_name                     | mobile      | landline    | email                      |
#      | Ms    | Mary       | Davidson  | Auto Test Applicant Business Name | 07774443333 | 01115555999 | auto_testing@hotmail.co.uk |
#    And I select No to site address same as applicant address
#    And I enter the applicant address postcode "<applicant_postcode>"
#    And I select county "<applicant_county>"
#    And I select No to paying for work
#    And I enter payment contact details:
#      | title | first_name | last_name | mobile      | landline    | email                          | postcode | county         |
#      | Rev   | George     | Richard   | 07774445555 | 01413333888 | george.richard@contractors.com | KA11 4DQ | South Ayrshire |
#    And I select Yes to company paying and enter company details:
#      | company_name      | vat_num    | company_num |
#      | Test Builders Ltd | GB12345678 | SC123456    |
#    And I select No to site contact
#    And I enter site contact details:
#      | title | first_name | last_name | position     | mobile      | landline    | email                       |
#      | Dr    | Sandra     | Johnson   | Site Manager | 07775555666 | 01217779999 | sandra_johnson@builders.com |
#    And I select meter type as "<meter>"
#    And I select Yes to target date and enter a future date
#    And I select "<contact>" as contact preference
#    And I enter additional information "<info>"
#    And I review my "Formal" quote application details and continue
#    And I click Edit button for "Connection Detail"
#    And I am taken to the Connection Details page
#    And I upload a file
#    Then I can submit my application
#    And I am taken to the "Move Meter" Formal quote app submission page
#    And My application is submitted successfully in the database
#
#    Examples:
#      | postcode | address                                 | works  | email        | password  | property | meter       | distance | phase        | applicant_postcode | applicant_county | contact | info                                              |
#      | L6 1LX   | 6 Upper Baker Street, Liverpool, L6 1LX | I will | [user_email] | [password] | House    | Smart Meter | 6        | Single phase | KA11 4DQ           | South Ayrshire   | Email   | Move Meter Fixed Price Formal - Contractor paying |
