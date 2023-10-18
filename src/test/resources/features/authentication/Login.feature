@outsystems-training @authentication
Feature: Authentication tests

  Background:
    Given the OutSystems training website is opened
    And I have a valid User credential

  @authentication-user @main-scope
  Scenario: CT_1 - User authentication
    When I accept the cookies
    And I access the login option
    And I enter the email to login
    And I enter the password to login
    Then I will be redirected to training page with my user logged