@authentication
Feature: Authentication tests

  Background:
    Given the OutSystems training website is opened

  @login @main
  Scenario Outline: CT_1 - User authentication
    When access login option
    And enter email <email> to login
    And enter password <password> to login
    Then user <email> will be redirected to training page with user logged

    Examples:
      | email                          | password    |
      | davi.outsystems.test@gmail.com | Out#Systems |