@Disconnections @DisconnectionInformalQuote @dev @test @prod @firefox
@Issue #SPFD-1031
Feature: Disconnection Informal Quote journey tests

  Background:
    Given the user is on the change connection page

  @smoke @regression
  Scenario Outline: Disconnection Informal quote - Customer is payee and site contact
    Given I select "Disconnection" application
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
    And I select "1-3" disconnections
    And I provide the Disconnection plot details:
      | plot | mpan   | site_address   | vacant   |
      | 1    | <mpan> | <site_address> | <vacant> |
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Disconnection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                          | postcode | county    | email        | password   | works | mpan          | site_address | vacant | contact | info                                      |
      | Disconnect electrical equipment, cable or plant | EH6 4JG  | Edinburgh | [user_email] | [password] | SPEN  | 1812345678901 | Yes          | Yes    | Email   | Disconnection Informal - SPEN to excavate |

  @regression
  Scenario Outline: Disconnection Informal quote - Multiple disconnections
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
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select "1-3" disconnections
    And I provide the Disconnection plot details:
      | plot | mpan          | site_address | site_postcode | county    | vacant |
      | 1    | 1345678901234 | No           | EH6 4NQ       | Edinburgh | No     |
      | 2    | 1834567890123 | Yes          |  N/A          | N/A       | Yes    |
      | 3    | 1323456789012 | Yes          |  N/A          | N/A       | No     |
    And I select "<contact>" as contact preference
    And I enter additional information "<info>"
    And I review my "Informal" quote application details and continue
    And I upload a file
    Then I can submit my application
    And I am taken to the "Disconnection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                                | postcode | county         | email        | password   | works  | contact | info                                             |
      | Disconnect multiple standard supplies | KA1 1ED  | South Ayrshire | [user_email] | [password] | I will | Phone   | Disconnection Informal - Multiple disconnections |


  @regression
  Scenario Outline: Disconnection - Edit Quote type and Excavation details from App Review page
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
    And I select Informal quote type
    And I select "<works>" to dig private land
    And I select Yes to site address same as applicant address
    And I select "1-3" disconnections
    And I provide the Disconnection plot details:
      | plot | mpan   | site_address   | vacant   |
      | 1    | <mpan> | <site_address> | <vacant> |
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
    And I am taken to the "Disconnection" Informal quote app submission page
    And My application is submitted successfully in the database

    Examples:
      | option                              | postcode | county    | email        | password   | works  | works_edit | mpan          | site_address | vacant | contact | info                                           |
      | Disconnect a single standard supply | EH6 4NQ  | Edinburgh | [user_email] | [password] | I will | SPEN       | 1812345678901 | Yes          | Yes    | Email   | Disconnection - Edit quote type and excavation |
