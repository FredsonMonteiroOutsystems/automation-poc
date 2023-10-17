@authentication
Feature: Authentication tests

  Background:
    Given the OutSystems training website is opened
    And I have a valid User credential

  @authentication-user @main-scope
  Scenario: CT_1 - User authentication
    When accept cookies
    And access login option
    And enter email to login
    And enter password to login
    Then user will be redirected to training page with user logged