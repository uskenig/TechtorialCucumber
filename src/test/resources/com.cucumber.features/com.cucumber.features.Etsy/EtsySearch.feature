Feature: Validation of Search in Etsy

  Background:
    Given the user navigate to the Etsy

  @positive
  Scenario: Validation of Wooden Spoon
    When the user search "Wooden Spoon"
    Then the user validate title "Wooden spoon | Etsy"

  @positive
  Scenario: Validation of MakeUp Organizer
    When the user search "make up organizer"
    Then the user validate title "Make up organizer | Etsy"