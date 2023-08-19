Feature: Recipes Feature

  Scenario: As a valid user I can see the recipes screen
    When I press view with id "recipesFragment"
    Then I see text containing "Seed Porridge"

  Scenario: I can open a recipe
    When I press view with id "recipesFragment"
    And I press view with id "placeholder_row_layout"
    Then I should see text containing "Seed Porridge"

  Scenario: I can open the ingredients screen
    When I press view with id "recipesFragment"
    And I press view with id "placeholder_row_layout"
    And I press view with id "ingredients_recyclerview"
    Then I should see text containing "Sesame seeds"

  Scenario: I can open the instructions screen/web view
    When I press view with id "recipesFragment"
    And I press view with id "placeholder_row_layout"
    And I press view with id "instructions_web_view"
    Then I should see text containing "Chia seed"

  Scenario: I can search recipes
    When I press view with id "recipesFragment"
    And I press view with id "menu_search"
    And I enter "Seed"
    Then I should see text containing "Seed Porridge"
