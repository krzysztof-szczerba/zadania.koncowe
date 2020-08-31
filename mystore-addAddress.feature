Feature: Log in into mystore
  Scenario Outline: Log into store as registered user
    Given User is not logged and is on <LoginPage>
    When user inputs <Email> into email field
    And user inputs <Password> into password field
    Then user clicks Sign In button
    Examples:
      |LoginPage|Email|Password|
      |https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account|kp.szczerba@gmail.com|12345|