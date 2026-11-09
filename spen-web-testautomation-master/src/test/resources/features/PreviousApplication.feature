@PreviousApplication @regression @dev @test @prod @firefox
@Issue #SPFD-1199
Feature: Previous Application journey tests


  @smoke
  Scenario Outline: "<app_name>" application - The design has changed
    Given the user is on the change connection page
    And I select "<app_name>" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "Yes" to previous application question
    And I select "The design has changed" update option
    Then I am shown the "<app_name>" application Submit New Application page

    Examples:
      | app_name             | option                                           | email        | password   | postcode |
      | Diversion            | Moving underground cables or overhead powerlines | [user_email] | [password] | G72 7DE  |
      | Disconnection        | Disconnect a single standard supply              | [user_email] | [password] | G72 7DE  |
      | Unmetered Connection | New unmetered supply on a new street             | [user_email] | [password] | G60 5EW  |
      | Additional Load      | I would like to alter my capacity agreement      | [user_email] | [password] | G60 5EW  |


  Scenario Outline: "<app_name>" application - "<reason>"
    Given the user is on the change connection page
    And I select "<app_name>" application
    And I select "<option>" change connection option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "Yes" to previous application question
    And I select "<reason>" update option
    And I enter the quote reference and contact details:
      | quote_ref | title   | first_name   | last_name   | mobile   | landline   | email   |
      | <ref>     | <title> | <first_name> | <last_name> | <mobile> | <landline> | <email> |
    And I click the Submit request button
    Then I am shown the "<app_name>" application Update Request confirmation page

    Examples:
      | app_name             | option                                                            | email        | password   | postcode | reason                                                   | ref      | title | first_name | last_name | mobile      | landline    | email                             |
      | Diversion            | Moving underground cables or overhead powerlines                  | [user_email] | [password] | G72 7DE  | The applicant, payment or site contact has changed       | 12345678 | Mr    | George     | Foreman   | 07774443333 | 01115555999 | sitecontact_changed@hotmail.co.uk |
      | Diversion            | Moving underground cables or overhead powerlines                  | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 23456789 | Mrs   | Daisy      | Williams  | 07775553333 | 01216665999 | quote.expired@gmail.com           |
      | Diversion            | Moving underground cables or overhead powerlines                  | [user_email] | [password] | G60 5EW  | Other                                                    | 34567890 | Rev   | George     | Foreman   | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |
      | Additional Load      | Increase the capacity of my connection                            | [user_email] | [password] | G60 5EW  | The applicant, payment or site contact has changed       | 45678901 | Ms    | Daisy      | Williams  | 07778888999 | 01418889999 | sitecontact_changed@hotmail.co.uk |
      | Additional Load      | Increase the capacity of my connection from single to three phase | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 45678901 | Mr    | George     | Foreman   | 07778888999 | 01418889999 | quote.expired@gmail.com           |
      | Additional Load      | I would like to alter my capacity agreement                       | [user_email] | [password] | G60 5EW  | Other                                                    | 45678901 | Dr    | Daisy      | Williams  | 07778888999 | 01418889999 | otherreason@yahoo.co.uk           |
      | Disconnection        | Disconnect a high-voltage supply                                  | [user_email] | [password] | G60 5EW  | The applicant, payment or site contact has changed       | 23456789 | Miss  | Daisy      | Williams  | 07775553333 | 01216665999 | sitecontact_changed@hotmail.co.uk |
      | Disconnection        | Disconnect multiple standard supplies                             | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 23456789 | Rev   | Daisy      | Foreman   | 07775553333 | 01216665999 | quote.expired@gmail.com           |
      | Disconnection        | Disconnect electrical equipment, cable or plant                   | [user_email] | [password] | G60 5EW  | Other                                                    | 23456789 | Mr    | George     | Foreman   | 07775553333 | 01216665999 | otherreason@yahoo.co.uk           |
      | Unmetered Connection | New unmetered supply on an existing street                        | [user_email] | [password] | G60 5EW  | The applicant, payment or site contact has changed       | 34567890 | Dr    | George     | Foreman   | 07776663333 | 01317775999 | sitecontact_changed@hotmail.co.uk |
      | Unmetered Connection | New unmetered supply on a new street                              | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 34567890 | Rev   | George     | Foreman   | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |
      | Unmetered Connection | New unmetered supply on an existing street                        | [user_email] | [password] | G60 5EW  | Other                                                    | 34567890 | Ms    | Daisy      | Williams  | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |


  @smoke
  Scenario Outline: New Connection "<connection>" property type - The design has changed
    Given the user is on the new connection page
    And I select "<connection>" connection type
    And I select "<property>" property type option
    And I select "<customer>" customer type option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "Yes" to previous application question
    And I select "The design has changed" update option
    Then I am shown the "New Connection" application Submit New Application page

    Examples:
      | connection            | property                                          | customer               | email        | password   | postcode |
      | House                 | 1 Property                                        | Homeowner / Tenant     | [user_email] | [password] | G72 7DE  |
      | Flat                  | Additional flat to existing property              | 3rd Party / Consultant | [user_email] | [password] | G72 7DE  |
      | Commercial Premises   | More than 250kva                                  | Commercial Business    | [user_email] | [password] | G60 5EW  |
      | Commercial EV Charger | A new connection for a domestic EV Charging Point | Property Developer     | [user_email] | [password] | G60 5EW  |


  Scenario Outline: New Connection "<connection>" property type - "<reason>"
    Given the user is on the new connection page
    And I select "<connection>" connection type
    And I select "<property>" property type option
    And I select "<customer>" customer type option
    And I enter a valid postcode "<postcode>" and click Check Now button
    And I click Apply Now and continue to application form
    And I login using email "<email>" and password "<password>"
    And I select "Yes" to previous application question
    And I select "<reason>" update option
    And I enter the quote reference and contact details:
      | quote_ref | title   | first_name   | last_name   | mobile   | landline   | email   |
      | <ref>     | <title> | <first_name> | <last_name> | <mobile> | <landline> | <email> |
    And I click the Submit request button
    Then I am shown the "New Connection" application Update Request confirmation page

    Examples:
      | connection            | property                                            | customer               | email        | password   | postcode | reason                                                   | ref      | title | first_name | last_name | mobile      | landline    | email                             |
      | House                 | 1 Property                                          | Homeowner / Tenant     | [user_email] | [password] | G72 7DE  | The applicant, payment or site contact has changed       | 12345678 | Mr    | George     | Foreman   | 07774443333 | 01115555999 | sitecontact_changed@hotmail.co.uk |
      | House                 | 2-4 Properties                                      | 3rd Party / Consultant | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 23456789 | Ms    | Daisy      | Williams  | 07775553333 | 01216665999 | quote.expired@gmail.com           |
      | House                 | More than 4 Properties                              | Property Developer     | [user_email] | [password] | G60 5EW  | Other                                                    | 34567890 | Rev   | George     | Foreman   | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |
      | Flat                  | New Build more than 4 flats                         | Homeowner / Tenant     | [user_email] | [password] | G72 7DE  | The applicant, payment or site contact has changed       | 12345678 | Mr    | George     | Foreman   | 07774443333 | 01115555999 | sitecontact_changed@hotmail.co.uk |
      | Flat                  | New build 1 - 4 flats                               | Housing Authority      | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 23456789 | Mrs   | Daisy      | Williams  | 07775553333 | 01216665999 | quote.expired@gmail.com           |
      | Flat                  | Conversion of old Commercial building into flats    | Property Developer     | [user_email] | [password] | G60 5EW  | Other                                                    | 34567890 | Rev   | George     | Foreman   | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |
      | Commercial Premises   | Up to 69kva                                         | Housing Authority      | [user_email] | [password] | G72 7DE  | The applicant, payment or site contact has changed       | 12345678 | Mr    | George     | Foreman   | 07774443333 | 01115555999 | sitecontact_changed@hotmail.co.uk |
      | Commercial Premises   | More than 69kva but less than 250kva                | Property Developer     | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 23456789 | Miss  | Daisy      | Williams  | 07775553333 | 01216665999 | quote.expired@gmail.com           |
      | Commercial Premises   | More than 250kva                                    | Commercial Business    | [user_email] | [password] | G60 5EW  | Other                                                    | 34567890 | Dr    | George     | Foreman   | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |
      | Commercial EV Charger | A new connection for a domestic EV Charging Point   | Property Developer     | [user_email] | [password] | G72 7DE  | The applicant, payment or site contact has changed       | 12345678 | Mr    | George     | Foreman   | 07774443333 | 01115555999 | sitecontact_changed@hotmail.co.uk |
      | Commercial EV Charger | A new connection for a commercial EV Charging Point | 3rd Party / Consultant | [user_email] | [password] | G60 5EW  | I need an updated quote as my existing quote has expired | 23456789 | Dr    | Daisy      | Williams  | 07775553333 | 01216665999 | quote.expired@gmail.com           |
      | Commercial EV Charger | A new connection for a commercial EV Charging Point | Housing Authority      | [user_email] | [password] | G60 5EW  | Other                                                    | 34567890 | Rev   | George     | Foreman   | 07776663333 | 01317775999 | otherreason@yahoo.co.uk           |
