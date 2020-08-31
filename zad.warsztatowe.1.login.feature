Feature: Login of an existing user
  Scenario: Log in an existing user by input of Email and Password and click on Sign In button
    Given User is not logged and is on page: https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account
    When User inputs Email
    And User inputs Password
    And User clicks on Sign In button
    Then User is logged on My Store website.