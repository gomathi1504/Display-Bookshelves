Feature: Validate GiftCard DataDriven with Excel

  Scenario Outline: Validating giftCard with valid,invalid inputs
    Given the user navigates to giftCard section
    Then user should be redirected to payment page by passing all details with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
      |         6 |
      |         7 |
      |         8 |
      |         9 |
      |         10|
      |         11|
      |         12|
      |         13|
