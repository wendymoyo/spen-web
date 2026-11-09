@NewConnectionLandingPages @smoke @regression @dev @test @prod @firefox
Feature: New Connection Landing Pages tests

  Background:
    Given the user is on the new connection page

  Scenario Outline: Independent Connection Providers Landing Page - "<connection>" property
    Given I select "<connection>" connection type
    And I select "<property>" property type option
    When I select "Independent Connection Provider" customer type option
    Then I am taken to the Independent Connection Providers page

    Examples:
      | connection            | property                                            |
      | House                 | More than 4 Properties                              |
      | Flat                  | New build containing flats & Commercial             |
      | Commercial Premises   | More than 250kva                                    |
      | Commercial EV Charger | A new connection for a commercial EV Charging Point |
