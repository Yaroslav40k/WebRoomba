@HooverAutoClean
Feature: HooverAutoClean

  Scenario Outline: I should have a hoover with empty dirt container after it finishes the clean up
    Given I have a grid with <number> patches of dirt
    And i have a hoover
    And i run a hoover to clean the dirt
    When a hoover finishes the cleanup having cleaned <number> patches of dirt
    Then it's dirt container should be empty
    Examples:
      | number |
      | 0      |
      | 1      |
      | 3      |
