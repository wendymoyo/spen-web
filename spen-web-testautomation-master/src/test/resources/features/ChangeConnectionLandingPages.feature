@ChangeConnectionLandingPages @smoke @regression @dev @test @prod @firefox
Feature: Change Connection Landing Pages tests

  Background:
    Given the user is on the change connection page

  Scenario: Additional Load - At Your Property page
    Given I select "Additional Load" application
    When I select "Check to see if my existing connection is capable of taking an increased load" change connection option
    Then I am taken to the At Your Property page

  Scenario: Add Solar Panel application
    Given I select "Add Solar Panel" application
    Then I am taken to the Distributed Generation page
