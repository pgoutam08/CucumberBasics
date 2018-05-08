#Author: Goutam Pattar
Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    # And I enter the Users email address as Email:admin
    # And I verify the count of my salary digits for JMD 150000
    # And I need to see how Step looks for cucumber-java8
    And I enter the following for Login
      | username | password      |
      | admin    | adminpassword |
    And I click on login button
    Then I should see the userform page
