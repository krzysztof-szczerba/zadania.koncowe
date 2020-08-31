Feature: Log in into mystore
  Scenario Outline: Log into store as registered user
    Given User is not logged and is on <LoginPage>
    When user inputs <Email> into email field
    And user inputs <Password> into password field
    And user clicks Sign In button
    And user clicks Addresses button
    And user clicks Create new address button
    And user inputs <Alias> in alias field
    And user inputs <Address> in address field
    And user inputs <City> in city field
    And user selects United Kingdom in Country drop-down list

    Examples:
      |LoginPage|Email|Password|Alias|Address|City|
      |https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account|kp.szczerba@gmail.com|12345|krzysiu|Glowna 2|Wroclaw|