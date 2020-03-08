Feature: Wex QA engineer tasks

  @ID-01
  Scenario: Keyword searches matches the displayed
    Given I navigate to “www\.wexinc\.com”\.
    When I select the search field
    Then I insert "credit" in the field
    And I press search
    Then I validate if the keyword searched match the displayed

  @ID-02
  Scenario: Enter valid keywords
    Given I navigate to “www\.wexinc\.com”\.
    When I select the search field
    Then I insert "health" in the field
    And I press search
    Then I validate the returned result

  @ID-03
  Scenario: Enter nothing
    Given I navigate to “www\.wexinc\.com”\.
    When I select the search field
    Then I insert "" in the field
    And I press search
    Then I validate if the search page is loaded

  @ID-04
  Scenario: Enter "%"
    Given I navigate to “www\.wexinc\.com”\.
    When I select the search field
    Then I insert "%" in the field
    And I press search
    Then I validate if the proper not found message is returned

  @ID-05
  Scenario: Navigate to result search
    Given I navigate to “www\.wexinc\.com”\.
    When I select the search field
    Then I insert "health" in the field
    And I press search
    Then I navigate to result search article

  @ID-06
  Scenario: Total result search
    Given I navigate to “www\.wexinc\.com”\.
    When I select the search field
    Then I insert "health" in the field
    And I press search
    Then I validate if total results does not exists