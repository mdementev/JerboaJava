Feature: Google search
  Scenario: Search google maps in google
    Given I navigate to "http://google.com"
    And Title is "Google"
    When I search for "Google"
    Then I found "Google Maps"