Feature: Login functionality

@Regresion
  Scenario Outline: Login to Sauce Demo using valid users
    When I enter username "<username>" and password "<password>"
    And I click on Login button
    Then I am logged in successfully and page title should be "Swag Labs"

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario: Login to Sauce Demo using locked out user
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click on Login button
    Then I am logged in successfully and page title should be "Swag Labs"
