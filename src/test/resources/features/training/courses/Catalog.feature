@courses
Feature: Courses tests

  # There are several approaches that can be considered here:
  # You can use the Login scenario as a Background, as I have done, or create a common method that can be called in both scenarios.
  # Another option is to keep the browser open after logging in. I don't prefer this approach unless it's truly necessary.

  Background:
    Given the OutSystems training website is opened
    And I have a valid User credential
    When accept cookies
    And access login option
    And enter email to login
    And enter password to login
    Then user will be redirected to training page with user logged

  @courses-search-filter-tag @main-scope
  Scenario Outline: CT_2 - Access the course through search and filter by tags
    When I access the menu Training >> Courses
    And I select tags <tags>
    And I choose the course <course>
    And I pick the <menu_option> option from the sidebar
    Then the course title should be <course>
    And the course should already be started

    Examples:
      | tags                       | course                                | menu_option                           |
      | Aggregate, Automated Tests | Introduction to Test Automation       | Introduction to Test Automation       |
      | Best Practices, Business   | Best Practices on Architecture Design | Best Practices on Architecture Design |