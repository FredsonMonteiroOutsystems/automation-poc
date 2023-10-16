@courses
Feature: Courses tests

  # There are several approaches that can be used here:
  # Background the Login scenario as I did or create a common method to be called in both of scenarios, for example.
  Background:
    Given the OutSystems training website is opened
    And I have a valid User credential
    When access login option
    And enter email to login
    And enter password to login
    Then user will be redirected to training page with user logged


  @courses-search-filter-tag @main-scope
  Scenario Outline: CT_2 - Access the course by searching and filtering using tags
    When access menu Training >> Courses
    And select tags <tags>
    And Select the course <course>
    And Select option <menu_option> on sidebar
    Then course title will be <course>
    And OutSystems Overview will be available

    Examples:
      | tags                       | course                                 | menu_option                            |
      | Aggregate, Automated Tests | Building Screens with Data             | Displaying Data on Screen              |
      | Best Practices, Business   | Monitoring Web and Mobile Applications | Monitoring Web and Mobile Applications |