@courses
Feature: Courses tests

  # Many kinds of approach can be used here:
  # Background the Login scenario as I did or create a common method to be called in both of scenarios, for example.
  Background:
    Given the OutSystems training website is opened
    And I have a valid User credential
    When access login option
    And enter email to login
    And enter password to login
    Then user will be redirected to training page with user logged


  @courses-search-filter-tag @main
  Scenario Outline: CT_2 - Access the course by searching and filtering using tags
    When access menu Training >> Courses
    And select tags <tags>
    And Select the course <course>
    Then title, sidebar, main content and start option will be displayed

    Examples:
      | tags                       | course                                 |
      | Aggregate, Automated Tests | Building Screens with Data             |
      | Best Practices, Business   | Monitoring Web and Mobile Applications |