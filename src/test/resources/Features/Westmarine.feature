Feature: Search feature

  @sitenavigation
  Scenario: Verify it's able to select any item from the search results
    Given I am on Home Page
    And I enter an item "Flip flops"
    When I click on the search icon
    Then I should able to see the search results
    And I am able to select one
    And selected item is the same displayed