@outsystems-training @journeys
Feature: Journeys tests

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

  @journeys-starting-journey @main-scope
  Scenario Outline: CT_3 - Start a training journey
    When I access the menu Training >> Guided Paths
    And I select the training journey <journey>
    And I pick the <course> option from the sidebar
    Then the course title should be <course>
    And the course should already be started

    Examples:
      | journey                        | course                             |
      | Delivering OutSystems Projects | OutSystems Delivery Core Behaviors |
      | DevOps in OutSystems           | OutSystems Overview                |