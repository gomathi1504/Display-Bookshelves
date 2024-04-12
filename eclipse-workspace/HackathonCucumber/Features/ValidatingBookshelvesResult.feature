Feature: Validate Bookshelves Result

  Scenario: validating the results of bookshelves
    Given the user search for "Bookshelves"
    When the user performs all conditions as per description
    Then the user sees the result page of the product
