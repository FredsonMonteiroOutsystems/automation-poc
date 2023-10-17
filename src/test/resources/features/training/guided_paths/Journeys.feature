@journeys
Feature: Journeys tests

  # There are several approaches that can be used here:
  # Background the Login scenario as I did or create a common method to be called in both of scenarios, for example.
  Background:
    Given the OutSystems training website is opened
    And I have a valid User credential
    When access login option
    And enter email to login
    And enter password to login
    Then user will be redirected to training page with user logged


  @journeys-starting-journey @main-scope
  Scenario Outline: CT_2 - Start a journey
    When access menu Training >> Courses
    And select tags <tags>
    And Select the course <course>
    Then title will be showed as expected
    And OutSystems Overview will be available

    Examples:
      | journey                                      |
      | Becoming a Web Developer                     |
      | Becoming a Front-End Developer in OutSystems |