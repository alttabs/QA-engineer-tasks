Feature: Wex QA engineer tasks

  @ID-01
  Scenario: Validate if the keyword searched was really what was searched by the system
    Given I navigate to “www.wexinc.com”
    When I select the search field
    Then I insert "credit" in the field
    And I press search
    Then I validate if the keyword searched matches what was actually searched by the system

  @ID-02
  Scenario: Test the search functionality when giving a valid word as a parameter
    Given I navigate to “www.wexinc.com”
    When I select the search field
    Then I insert "credit" in the field
    And I press search
    Then I validate the returned result

  @ID-03
  Scenario: Test the search functionality when not giving any keyword
    Given I navigate to “www.wexinc.com”
    When I select the search field
    Then I insert "" in the field
    And I press search
    Then I validate if the search page is loaded

  @ID-04
  Scenario: Test the search functionality when giving a special character as a parameter
    Given I navigate to “www.wexinc.com”
    When I select the search field
    Then I insert "%" in the field
    And I press search
    Then I validate if the proper not found message is returned

  @ID-05
  Scenario: Validate if the result returned at the list links to the correct specific article
    Given I navigate to “www.wexinc.com”
    When I select the search field
    Then I insert "credit" in the field
    And I press search
    Then validate if the resulting article is really what is being shown as result

  @ID-06
  Scenario: Check if there is displayed the total number of results for any valid search
    Given I navigate to “www.wexinc.com”
    When I select the search field
    Then I insert "credit" in the field
    And I press search
    Then I validate if the counter for total results does not exist