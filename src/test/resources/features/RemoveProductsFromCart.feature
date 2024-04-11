Feature: Remove Products from Cart

  Background: 
    Given I enter username "standard_user" and password "secret_sauce"
    And I click on Login button

  Scenario: Remove product from Products page
    Given I add specific products to cart
      | products                 |
      | Sauce Labs Onesie        |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
    When I remove specific products from cart
      | products                 |
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |
    Then I see total 1 items are added to cart

  Scenario: Remove specific products from cart whe all products are added to the cart
    Given I add all products to cart
    When I remove specific products from cart
      | products                 |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |
    Then I see total 3 items are added to cart

@Regresion
  Scenario: Remove products from Your Cart page
    Given I add specific products to cart
      | products                 |
      | Sauce Labs Onesie        |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
    And I click on cart icon
    When I remove specific products from Your Cart page 
      | products          |
      | Sauce Labs Onesie |
    Then I see total 2 items are added to cart

  Scenario: Remove all products from Your Cart page
    Given I add specific products to cart
      | products                 |
      | Sauce Labs Bike Light    |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
    And I click on cart icon
    When I remove all products from Your Cart page
    Then I see total 0 items are present in the cart
