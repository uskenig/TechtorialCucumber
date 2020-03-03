Feature: WebOrders login functionality

  @positive @smoke
  Scenario: WebOrders login positive testing 1
    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password
    Then the user should see home page

  @negative @smoke
  Scenario: WebOrders menu negative testing
    Given the user navigate to the web orders page
    When the user provide username "Test"
    And the user provide password "admin"
    Then the user validate text "Invalid Login or Password."

  @negative
  Scenario: WebOrders menu negative testing with numbers
    Given the user navigate to the web orders page
    When the user provide username 1234
    And the user provide password 4567
    Then the user validate text "Invalid Login or Password."

  @negative
  Scenario: WebOrders menu negative testing 2
    Given the user navigate to the web orders page
    When the user provide username "Tester" and password "tt"
    Then the user validate text "Invalid Login or Password."

    @menuList
    Scenario: WebOrders menu positive testing 2
      Then the user validate order menu list