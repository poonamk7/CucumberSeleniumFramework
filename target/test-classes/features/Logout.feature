Feature: Logout funtionality

Background: 
    Given I enter username "standard_user" and password "secret_sauce"
    And I click on Login button

  Scenario: Logout from Products page

    When I click on Hamburger menu from Products page
    And I click on Logout link
    Then I am logged out of Sauce Demo page

  Scenario: Logout from Your Cart page
    Given I add all products to cart
    And I click on cart icon
    When I click on Hamburger menu from Your Cart page
    And I click on Logout link from Your Cart page
    Then I am logged out of Sauce Demo page

  Scenario: Logout from Checkout Your Information page
    Given I add specific products to cart
      | products          |
      | Sauce Labs Onesie |
    And I click on cart icon
    And I click on Checkout button
    When I click on Hamburger menu from Checkout Your Information page
    And I click on Logout link from Checkout Your Information page
    Then I am logged out of Sauce Demo page

  Scenario: Logout from Checkout Overview page
    Given I add specific products to cart
      | products          |
      | Sauce Labs Onesie |
    And I click on cart icon
    And I click on Checkout button
    And I provide details on Your Information page
    And I click on Continue button
    When I click on Hamburger menu from Checkout Overview page
    And I click on Logout link from Checkout Overview page
    Then I am logged out of Sauce Demo page

@Regresion
  Scenario: Logout from Checkout Complete page
    Given I add specific products to cart
      | products                |
      | Sauce Labs Bolt T-Shirt |
    And I click on cart icon
    And I click on Checkout button
    And I provide details on Your Information page
    And I click on Continue button
    And I click Finish button on Overview screen
    When I click on Hamburger menu from Checkout Complete page
    And I click on Logout link from Checkout Complete page
    Then I am logged out of Sauce Demo page
