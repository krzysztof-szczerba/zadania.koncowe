Feature: Login, selection of items, order and payment
  Scenario Outline: Log into store as registered user, select products, order them and pay
    Given Registered user is not logged and is on login page
    When Registered user inputs <Email> into email field
    And Registered user inputs <Password> into password field
    And Registered user clicks Sign In button
    And User clicks on Search Our Catalog field
    And User selects quantity of a product
    And Proceed to Checkout

    Examples:
      |Email|Password|
      |kp.szczerba@gmail.com|12345|