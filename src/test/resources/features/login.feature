@login
Feature:Login tests

  @smoke
  Scenario: Valid user login test
    When user logs in with valid admin credentials
    Then welcome message is displayed in dashboard page

  @smoke
  Scenario: Valid username invalid password test
    When user pass the valid username and invalid password
    Then login error message for invalid password is displayed

  @regression @smoke
  Scenario: Valid username empty password test
    When user pass the valid username and empty password
    Then login error message for empty password is displayed


    #  TestNG  order ===> Actual, Expected, Optional Message.
    #  JUnit   order ===> Optional Message, Expected, Actual