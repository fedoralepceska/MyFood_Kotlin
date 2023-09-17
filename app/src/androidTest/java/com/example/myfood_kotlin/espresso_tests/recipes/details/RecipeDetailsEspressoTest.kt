package com.example.myfood_kotlin.espresso_tests.recipes.details

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before

class RecipeDetailsEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    // TODO: mesto ova, probaj pred add preku state na kopcheto favorite za prviot element da proverish dali e favorite ili ne
    @Test
    fun testDeleteAllFavorites(){
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Open the overflow menu in the app bar (click the three dots button)
        Espresso.openActionBarOverflowOrOptionsMenu(context)
        // Click on the Delete All button
        onView(withText("Delete All"))
            .perform(click())
        // Check whether all favorite recipes are deleted
        onView(withId(R.id.no_data_image_view)).check(matches(isDisplayed()))
    }

    // Overview (main details) section
    @Test
    fun testOpeningRecipe(){
        // click on first recipe
        onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // check whether the correct recipe is displayed
        onView(withId(R.id.title_textView))
            .check(matches(isDisplayed()))
    }

    // Scenario 1: add to favorites
    @Test
    fun testAddToFavorites(){
        // click on first recipe
        onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on the favorites button
        onView(withId(R.id.save_to_favorites_menu))
            .perform(click())

        // check the state of the button
//        onView(withId(R.id.save_to_favorites_menu)).check(matches(isChecked()))

        // check whether the right text is displayed
        onView(withText("Recipe saved.")).check(matches(isDisplayed()))
    }

    // Scenario 2: remove from favorites
    @Test
    fun testRemoveFromFavorites(){
        // click on first recipe
        onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on the favorites button
        onView(withId(R.id.save_to_favorites_menu))
            .perform(click())

        // check the state of the button
//        onView(withId(R.id.save_to_favorites_menu)).check(matches(isNotChecked()))

        // check whether the right text is displayed
        onView(withText("Removed from Favorites.")).check(matches(isDisplayed()))
    }

    // Ingredients section
    @Test
    fun testIngredientsSection(){
        // click on first recipe
        onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on the ingredients button
        onView(withText("Ingredients")).perform(click())
        // check whether instructions section is displayed
        onView(withId(R.id.ingredients_recyclerview)).check(matches(isDisplayed()))

    }

    // Instructions section
    @Test
    fun testInstructionsSection(){
        // click on first recipe
        onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on the instructions button
        onView(withText("Instructions")).perform(click())
        // check whether instructions section is displayed
        onView(withId(R.id.instructions_web_view)).check(matches(isDisplayed()))
    }

}