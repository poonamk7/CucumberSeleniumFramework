Feature: Add to cart functionality

  Background: 
    Given I enter username "standard_user" and password "secret_sauce"
    And I click on Login button

  Scenario: Add all products to cart
    When I add all products to cart
    Then I see total 6 items are added to cart

@Regresion
  Scenario: Add specific products to cart
    When I add specific products to cart
      | products                 |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Onesie        |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
    Then I see total 4 items are added to cart


