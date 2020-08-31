//Feature: Login of an existing user and creation of a new address
Scenario: Login in user and create new address and fill in address form with alias, address, city, zip/postal code, country and phone
Given User is not logged and is on page: https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account
When User inputs Email
And User inputs Password
And User saves information
Then User sees "Information successfully updated.