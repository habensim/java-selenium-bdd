Feature: Login Website
  As a user
  I want to login with username and password
  So that I can success login
  As a user
  I want to login with username and password wrong
  So got the error message

  Scenario: Login Valid
    Given I am on the page login
    When I put "tomsmith" and "SuperSecretPassword!"
    And I click login button
    Then I Success login
    And I verify alert success

  Scenario: Login Invalid username
    Given I am on the page login
    When I put "tomsmith1" and "SuperSecretPassword!"
    And I click login button
    Then I got error message
