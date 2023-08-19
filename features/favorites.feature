Feature: Favorite Recipes Feature

  Scenario: As a valid user I can see the favorite recipes screen
    When I press view with id "favoriteRecipesFragment"
    Then I see text containing "No Favorite Recipes"

  Scenario: I can delete all favorites
    When I press view with id "favoriteRecipesFragment"
    And I press view with id "delete_favorite_recipe_menu"
    Then I should see text containing "Delete All"
