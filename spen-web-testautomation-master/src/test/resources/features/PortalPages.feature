@PortalPages @regression @dev @test @prod @firefox
Feature: Portal Pages tests

  Background:
    Given the user is on the SPEN app page


  Scenario Outline: See profile details
    Given I login using email "<email>" and password "<password>"
    And I click on my email address at the top of the page
    When I click "My Profile" link
    Then I am taken to my User Profile details page

    Examples:
      | email        | password   |
      | [user_email] | [password] |


  Scenario Outline: User logs in and log out successfully
    Given I login using email "<email>" and password "<password>"
    And I click on my email address at the top of the page
    When I click "Log Out" link
    Then I am logged out of the application

    Examples:
      | email        | password   |
      | [user_email] | [password] |


  @Issue #SPFD-1194
  Scenario Outline: Change profile details
    Given I login using email "<email>" and password "<password>"
    And I click on my email address at the top of the page
    And I click "My Profile" link
    And I click "Edit" button
    When I change my last name to "<surname>"
    And I click "Save" button
    Then The page is refreshed and my profile details have been updated

    Examples:
      | email        | password   | surname |
      | [user_email] | [password] | Testing |
      | [user_email] | [password] | Test    |


  Scenario Outline: Cancel password change
    Given I login using email "<email>" and password "<password>"
    And I click on my email address at the top of the page
    And I click "Change Password" link
    When I enter my current password "<password>" and my new password "<new_password>"
    And I click "Cancel" button
    Then I am taken to my Home page and my password is not changed

    Examples:
      | email        | password   | new_password |
      | [user_email] | [password] | Testpass5    |


  # Run this test only when necessary
  @Issue #SPFD-1193
  @ignore @wip
  Scenario Outline: Change password
    Given I login using email "<email>" and password "<password>"
    And I click on my email address at the top of the page
    And I click "Change Password" link
    When I enter my current password "<password>" and my new password "<new_password>"
    And I click "Reset Password" button
    Then I am shown a message that my password has been updated

    Examples:
      | email        | password   | new_password |
      | [user_email] | [password] | [password]   |
      | [user_email] | [password] | [password]   |


#  @wip
#  Scenario Outline: Portal pages navigation
#    Given I login using email "<email>" and password "<password>"
#    When I click "Getting Connected" button
#    Then I am taken to the "Getting Connected" page
#
#    Examples:
#      | email        | password  |
#      | [user_email] | [password] |


  # Run this test in Prod/ Live environment only!
  @regression @wip
  Scenario Outline: PACE form
    Given I login using email "<email>" and password "<password>"
    And I click "New Pre Application" under the Transmission Connections section
    And I am taken to the PACE form page
    And My company name, email and mobile number are pre-populated as: "<company_name>", "<email>" and "<mobile>"
    When I complete the PACE form
#    And I click "Submit" button
#    Then The form is submitted

    Examples:
      | email        | password   | company_name      | mobile      |
      | [user_email] | [password] | Test Builders Ltd | 07773334455 |