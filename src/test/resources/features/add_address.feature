Feature: Managing addresses on mystore-testlab

  Scenario Outline:
    Given I am on the mystore login page
    When I login with email "hukkfetnaufwdhrepw@hthlm.com" and password "Miszkablue1"
    Then I should be logged in successfully
    When I click on the Addresses tile
    Then I should be on the addresses page
    When I fill the address form with alias "<alias>", address "<address>", city "<city>", zip "<zip>", country "<country>", phone "<phone>"
    Then The new address should be added with alias "<alias>", address "<address>", city "<city>", zip "<zip>", country "<country>", phone "<phone>"
    And The browser closes
    Examples:
      | alias | address       | city     | zip    | country        | phone     |
      | Home  | ul. Testowa 1 | Katowice | 40-000 | United Kingdom | 777888999 |
      | Work  | ul. Pracy 10  | Gliwice  | 45-000 | United Kingdom | 111333999 |