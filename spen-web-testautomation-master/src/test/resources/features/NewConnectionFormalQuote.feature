@NewConnections @NewConnectionFormalQuote @dev @test @prod
Feature: New Connection Formal Quote journey tests

  Background:
    Given the user is on the new connection page

  @Issue #SPFD-1027
  @smoke @regression @firefox
  Scenario Outline: New Connection Formal quote - "<connection>" property & Customer is payee and site contact
    Given I select "<connection>" connection type
    And I select "<property>" property type option
    And I select "<customer>" customer type option
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
    And I select "1-4" connections
    And I select the Connection plots for New connection property types:
      | property | plots |
      | <type>   | 1     |
    And I provide Connection details for each plot:
      | plot   | heating   | max_load   | phase   | other_loads   | gen_storage   | tech   | rating   | location   |
      | <plot> | <heating> | <max_load> | <phase> | <other_loads> | <gen_storage> | <tech> | <rating> | <location> |
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "New Connection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection | property                             | customer               | postcode | county         | works  | type  | plot    | heating                | max_load | phase        | other_loads        | gen_storage | tech                    | rating | location     | contact | info                                     |
      | [user_email] | [password] | House      | 1 Property                           | Homeowner / Tenant     | EH6 4NQ  | Edinburgh      | I will | House | House 1 | Gas, Oil or No heating | 15       | Single phase | 3-Phase EV Charger | Yes         | PV (Solar Panels)       | 7      | Garage       | Phone   | New Connection - House Formal quote test |
      | [user_email] | [password] | Flat       | Additional flat to existing property | 3rd Party / Consultant | KA11 4DQ | South Ayrshire | SPEN   | Flat  | Flat 1  | Air Source Heat Pump   | 130      | Three phase  | Welding Equipment  | Yes         | Combined Heat and Power | 89     | Other street | Post    | New Connection - Flat Formal quote test  |


  @Issue #SPFD-1071
  @regression
  Scenario Outline: New Connection Formal quote - Contractor is paying & Four connection plots
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
      | title | first_name | last_name | mobile      | landline    | email                          | postcode | county         |
      | Mr    | George     | Richard   | 07774445555 | 01413333888 | george.richard@contractors.com | KA11 4DQ | South Ayrshire |
    And I select Yes to company paying and enter company details:
      | company_name      | vat_num    | company_num |
      | Test Builders Ltd | GB12345678 | SC123456    |
    And I select No to site contact
    And I enter site contact details:
      | title | first_name | last_name | position     | mobile      | landline    | email                       |
      | Mrs   | Sandra     | Johnson   | Site Manager | 07775555666 | 01217779999 | sandra_johnson@builders.com |
    And I select "1-4" connections
    And I select the Connection plots for New connection property types:
      | property                  | plots |
      | Flat                      | 1     |
      | Landlord                  | 1     |
      | Commercial                | 1     |
      | Multiple EV Charge points | 1     |
    And I provide Connection details for each plot:
      | plot         | heating                         | max_load | phase        | business_type     | ev_charge | other_loads                            | gen_storage | tech                    | rating | location                       |
      | Flat 1       | Storage Heating (Space & Water) | 5        | Single phase | N/A               | N/A       | None                                   | No          | N/A                     | N/A    | Flat Location - Rooftop        |
      | Landlord 1   | Gas, Oil or No heating          | 41       | Three phase  | N/A               | N/A       | Welding Equipment, Other               | Yes         | Hydro power system      | 75     | None                           |
      | Commercial 1 | Ground / Water Source Heat Pump | 599      | Three phase  | Convenience Store | N/A       | Swimming Pool, Large Electrical Motors | Yes         | Combined Heat and Power | 270    | Commercial Location - Basement |
      | EvCharger 1  | Electric Central Heating        | 8        | Single phase | N/A               | Fastest   | 3-Phase EV Charger                     | Yes         | Wind turbine            | 53     | EvCharger Location - Garage    |
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "New Connection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection          | property         | customer            | postcode | county    | works  | applicant_postcode | applicant_county  | contact | info                     |
      | [user_email] | [password] | Commercial Premises | More than 250kva | Commercial Business | EH6 4NQ  | Edinburgh | I will | G77 5LH            | East Renfrewshire | Post    | New Connection - 4 plots |


  @Issue #SPFD-1186
  @regression @firefox
  Scenario Outline: New Connection Formal quote - Upload spreadsheet for "<connection>" property
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
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select "5 or more" connections
    And I upload a New connection spreadsheet
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "New Connection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection          | property                                         | customer           | postcode | county         | works  | contact | info                                                  |
      | [user_email] | [password] | Flat                | Conversion of old Commercial building into flats | Property Developer | EH6 4JG  | Edinburgh      | I will | Post    | New Connection Formal - Flat upload spreadsheet       |
      | [user_email] | [password] | Commercial Premises | Up to 69kva                                      | Housing Authority  | KA1 1ED  | South Ayrshire | SPEN   | Phone   | New Connection Formal - Commercial upload spreadsheet |


  @Issue #SPFD-1188 #SPFD-1189
  @regression @firefox
  Scenario Outline: New Connection Formal quote - "<connection>" property with 2 plots
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
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select Yes to paying for work
    And I select Yes to site contact
    And I select "1-4" connections
    And I select the Connection plots for New connection property types:
      | property | plots |
      | <type>   | 2     |
    And I provide Connection details for each plot:
      | plot     | heating                  | max_load | phase        | other_loads             | gen_storage | tech    | rating | location |
      | <plot_1> | Hybrid Heat Pump         | 789      | Three phase  | Large Electrical Motors | Yes         | Battery | 465    | Hallway  |
      | <plot_2> | Electric Central Heating | 13       | Single phase | None                    | No          | N/A     | N/A    | None     |
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "New Connection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | email        | password   | connection            | property                                          | customer               | postcode | county            | works  | type      | plot_1      | plot_2      | contact | info                               |
      | [user_email] | [password] | Flat                  | New build 1 - 4 flats                             | Housing Authority      | G72 9PB  | South Lanarkshire | SPEN   | Flat      | Flat 1      | Flat 2      | Phone   | New Connection - 2 Flat plots      |
      | [user_email] | [password] | Commercial EV Charger | A new connection for a domestic EV Charging Point | Property Developer     | EH6 4JG  | Edinburgh         | I will | Temporary | Temporary 1 | Temporary 2 | Email   | New Connection - 2 Temporary plots |
      | [user_email] | [password] | Commercial Premises   | More than 69kva but less than 250kva              | 3rd Party / Consultant | KA1 1ED  | South Ayrshire    | SPEN   | Landlord  | Landlord 1  | Landlord 2  | Email   | New Connection - 2 Landlord plots  |