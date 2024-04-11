Feature: Checkout functionality

Background:
Given I enter username "standard_user" and password "secret_sauce"
    And I click on Login button
    And I add specific products to cart
    | products |
    | Sauce Labs Bike Light |
    | Sauce Labs Onesie |

Scenario: Checkout and complete purchase

    When I click on cart icon
    And I click on Checkout button
    And I provide details on Your Information page  
    And I click on Continue button
    And I click Finish button on Overview screen
    Then I see successful order message on page
 
 @Regresion   
 Scenario: Error validations on Checkout Your Information page
 
   When I click on cart icon
   And I click on Checkout button 
   And I click on Continue button
   Then I see validation message "Error: First Name is required" 
   When I provide First name
   And I click on Continue button
   Then I see validation message "Error: Last Name is required"
    When I provide Last name
   And I click on Continue button
   Then I see validation message "Error: Postal Code is required"
   When I provide Postal code
   And I click on Continue button
   Then I am navigated to "Checkout: Overview" page
 
    