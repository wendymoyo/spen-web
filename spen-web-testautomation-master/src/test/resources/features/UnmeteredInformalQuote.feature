@UnmeteredConnections @UnmeteredInformalQuote @dev @test @prod @firefox
@Issue #SPFD-1029
Feature: Unmetered Connection Informal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Unmetered Connection Informal quote - Customer is payee and site contact
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
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I enter the applicant address postcode "<postcode>"
    And I select county "<county>"
    And I provide Unmetered Connection plot details:
      | connection        | phase          | number         |
      | Advertising board | <advert_phase> | <advert_count> |
      | Control pillar    | <pillar_phase> | <pillar_count> |
    And I enter the mpan number "<mpan>"
    And I select connection adopted as "<adopted>"
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Unmetered Connection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                     | email        | password   | postcode | county            | works  | advert_phase | advert_count | pillar_phase | pillar_count | mpan          | adopted | contact | info                                      |
      | New unmetered supply on an existing street | [user_email] | [password] | G72 7DE  | South Lanarkshire | SPEN   | Three        | 4            | Single       | 2            | 1812345678901 | No      | Email   | Unmetered Informal - SPEN to excavate     |
      | New unmetered supply on a new street       | [user_email] | [password] | KA11 4DQ | South Ayrshire    | I will | Single       | 5            | Three        | 3            | 1312345678901 | Yes     | Phone   | Unmetered Informal - Customer to excavate |


  @regression
  Scenario Outline: Unmetered Connection - Edit Quote type and Excavation details from App Review page
    Given I select "Unmetered Connection" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "No" to previous application question
    When I enter the site address postcode "<postcode>"
    And I select an address from the list and county "<county>"
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I enter the applicant address postcode "<postcode>"
    And I select county "<county>"
    And I provide Unmetered Connection plot details:
      | connection        | phase          | number         | other_info   |
      | Street Light      | <lights_phase> | <lights_count> | N/A          |
      | Other equipment   | <other_phase>  | <other_count>  | <other_info> |
    And I enter the mpan number "<mpan>"
    And I select connection adopted as "<adopted>"
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
    And I am taken to the "Unmetered Connection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                     | email        | password   | postcode | county            | works  | works_edit | lights_phase | lights_count | other_phase | other_count | other_info           | mpan          | adopted | contact | info                                       |
      | New unmetered supply on a new street       | [user_email] | [password] | KA11 4DQ | South Ayrshire    | I will | SPEN       | Three        | 2            | Single      | 4           | Unmetered quote test | 1823456789012 | No      | Post    | Unmetered - Edit quote type and excavation |

