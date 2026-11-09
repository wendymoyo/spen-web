@UnmeteredConnections @UnmeteredFormalQuote @dev @test @prod
@Issue #SPFD-1026
Feature: Unmetered Connection Formal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Unmetered Connection Formal quote - Customer is payee and site contact
    Given I select "Unmetered Connection" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
#    When I enter the unmetered site address and postcode "<postcode>" manually
#    And I select county "<county>"
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I enter the applicant address postcode "<postcode>"
    And I select county "<county>"
    And I select Yes to paying for work
    And I select Yes to site contact
    And I provide Unmetered Connection plot details:
      | connection        | phase          | number         | other_info   |
      | Street Light      | <lights_phase> | <lights_count> | N/A          |
      | Advertising board | <advert_phase> | <advert_count> | N/A          |
      | Control pillar    | <pillar_phase> | <pillar_count> | N/A          |
      | Other equipment   | <other_phase>  | <other_count>  | <other_info> |
    And I enter the mpan number "<mpan>"
    And I select connection adopted as "<adopted>"
    And I select Yes to target date and enter a future date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Unmetered Connection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                     | email        | password   | postcode | county            | works  | lights_phase | lights_count | advert_phase | advert_count | pillar_phase | pillar_count | other_phase | other_count | other_info                  | mpan          | adopted | contact | info                                    |
      | New unmetered supply on a new street       | [user_email] | [password] | KA11 4DQ | South Ayrshire    | SPEN   | Single       | 3            | Three        | 2            | Single       | 5            | Three       | 1           | Unmetered Formal quote test | 1312345678901 | Yes     | Phone   | Unmetered Formal - SPEN to excavate     |
      | New unmetered supply on an existing street | [user_email] | [password] | G72 7DE  | South Lanarkshire | I will | Single       | 3            | Three        | 2            | Single       | 5            | Three       | 1           | Unmetered Formal quote test | 1312345678901 | Yes     | Post    | Unmetered Formal - Customer to excavate |


  @smoke @regression @firefox
  Scenario Outline: Unmetered Connection Formal quote - Contractor is paying
    Given I select "Unmetered Connection" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Formal quote type
    And I select "<works>" to dig private land
    And I enter the applicant address postcode "<postcode>"
    And I select county "<county>"
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
    And I provide Unmetered Connection plot details:
      | connection        | phase          | number         | other_info   |
      | Street Light      | <lights_phase> | <lights_count> | N/A          |
      | Advertising board | <advert_phase> | <advert_count> | N/A          |
      | Control pillar    | <pillar_phase> | <pillar_count> | N/A          |
      | Other equipment   | <other_phase>  | <other_count>  | <other_info> |
    And I enter the mpan number "<mpan>"
    And I select connection adopted as "<adopted>"
    And I select No to target date
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Formal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Unmetered Connection" Formal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                     | email        | password   | postcode | county    | works | lights_phase | lights_count | advert_phase | advert_count | pillar_phase | pillar_count | other_phase | other_count | other_info                  | mpan          | adopted | contact | info                                    |
      | New unmetered supply on a new street       | [user_email] | [password] | EH6 4JG  | Edinburgh | SPEN  | Single       | 1            | Three        | 4            | Single       | 2            | Three       | 3           | Unmetered Formal quote test | 1312345678901 | Yes     | Email   | Unmetered Formal - Contractor is paying |
