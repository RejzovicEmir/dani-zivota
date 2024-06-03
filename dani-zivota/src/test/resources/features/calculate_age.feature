Feature: Calculate age in days

  Scenario: User enters a valid date of birth
    Given the user's date of birth is "01-01-2000"
    When I calculate the age in days
    Then the age in days should be greater than 0

  Scenario: User enters an invalid date of birth in the future
    Given the user's date of birth is "01-01-3000"
    When I calculate the age in days
    Then an error message "Date of birth must be in the past" should be shown

  Scenario: User enters an invalid date format
    Given the user's date of birth is "31-02-2000"
    When I calculate the age in days
    Then an error message "Invalid date format" should be shown
