Feature: Food Joke Feature

  Scenario: As a valid user I can see the food joke screen
    When I press view with id "foodJokeFragment"
    Then I press view with id "food_joke_card_view"

  Scenario: I can share a food joke
    When I press view with id "foodJokeFragment"
    And I press view with id "share_food_joke_menu"
    Then I should see text containing "Share with Messages"