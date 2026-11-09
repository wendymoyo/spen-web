@NewConnections @NewConnectionInformalQuote @dev @test @prod @firefox
@Issue #SPFD-1028
Feature: New Connection Informal Quote journey tests

  Background:
    Given the user is on the new connection page

  @smoke @regression
  Scenario Outline: New Connection Informal quote - "<connection>" property & Customer is payee and site contact
    Given I select "<connection>" connection type
    And I select "<property>" property type option
    And I select "<customer>" customer type option
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
    And I select "1-4" connections
    And I select the Connection plots for New connection property types:
      | property | plots |
      | <type>   | 1     |
    And I provide Connection details for each plot:
      | plot     | heating   | max_load   | phase   | other_loads   | gen_storage | tech   | rating   | location   |
      | <type> 1 | <heating> | <max_load> | <phase> | <other_loads> | Yes         | <tech> | <rating> | <location> |
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "New Connection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection | property   | customer           | postcode | county    | works  | type  | heating                | max_load | phase        | other_loads        | tech    | rating | location         | contact | info                                           |
      | [user_email] | [password] | House      | 1 Property | Homeowner / Tenant | EH6 4NQ  | Edinburgh | I will | House | Gas, Oil or No heating | 15       | Single phase | 3-Phase EV Charger | Battery | 7      | Outside building | Phone   | New Connection Informal - Customer to excavate |


  @regression
  Scenario Outline: New Connection Informal quote - Upload spreadsheet for "<connection>" property
    Given I select "<connection>" connection type
    And I select "<property>" property type option
    And I select "<customer>" customer type option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I enter the applicant details:
      | title | first_name | last_name | business_name                     | mobile      | landline    | email                   |
      | Mr    | Steven     | Stuart    | Auto Test Applicant Business Name | 07779988877 | 02034445566 | steven.stuart@gmail.com |
    And I select No to site address same as applicant address
    And I enter the applicant address postcode "<applicant_postcode>"
    And I select county "<applicant_county>"
    And I select "5 or more" connections
    And I upload a New connection spreadsheet
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "New Connection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection          | property         | customer           | postcode | county            | works | applicant_postcode | applicant_county | contact | info                                         |
      | [user_email] | [password] | Commercial Premises | More than 250kva | Property Developer | ML3 7SP  | North Lanarkshire | SPEN  | KA11 4DQ           | South Ayrshire   | Email   | New Connection Informal - Upload spreadsheet |


  @regression
  Scenario Outline: New Connection "<connection>" property - Edit Quote type and Excavation details from App Review page
    Given I select "<connection>" connection type
    And I select "<property>" property type option
    And I select "<customer>" customer type option
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
    And I select "1-4" connections
    And I select the Connection plots for New connection property types:
      | property | plots |
      | <type>   | 1     |
    And I provide Connection details for each plot:
      | plot     | heating   | max_load   | phase   | other_loads   | gen_storage | tech   | rating   | location   |
      | <type> 1 | <heating> | <max_load> | <phase> | <other_loads> | Yes         | <tech> | <rating> | <location> |
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
    And I am taken to the "New Connection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection          | property                             | customer               | postcode | county            | works  | works_edit | type       | heating                         | max_load | phase        | other_loads        | tech                    | rating | location         | contact | info                                                  |
      | [user_email] | [password] | Flat                | Additional flat to existing property | 3rd Party / Consultant | G72 9PB  | South Lanarkshire | I will | SPEN       | Flat       | Storage Heating (Space & Water) | 158      | Three phase  | Welding Equipment  | Combined Heat and Power | 280    | Rooftop          | Post    | New Connection Flat - Edit quote type and excavation  |
      | [user_email] | [password] | House               | More than 4 Properties               | Property Developer     | EH6 4NQ  | Edinburgh         | I will | SPEN       | House      | Gas, Oil or No heating          | 60       | Single phase | 3-Phase EV Charger | Battery                 | 7      | Outside building | Phone   | New Connection House - Edit quote type and excavation |