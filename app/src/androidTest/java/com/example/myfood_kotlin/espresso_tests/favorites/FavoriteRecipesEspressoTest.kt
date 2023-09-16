package com.example.myfood_kotlin.espresso_tests.favorites

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry

@RunWith(AndroidJUnit4::class)
class FavoriteRecipesEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    // function which returns true if the recycler view is displayed
    fun ViewInteraction.isDisplayed(): Boolean {
        try {
            check(matches(ViewMatchers.isDisplayed()))
            return true
        } catch (e: NoMatchingViewException) {
            return false
        }
    }

    // Scenario 1: Favorite recipes are present

    @Test
    fun testRecyclerViewIsDisplayed() {
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the RecyclerView is displayed
        onView(withId(R.id.favoriteRecipesRecyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun testNoDataImageViewIsNotDisplayed() {
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the ImageView representing "no data" is displayed
        onView(withId(R.id.no_data_image_view)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testNoDataTextViewIsNotDisplayed() {
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the TextView with the "no favorite recipes" message is displayed
        onView(withId(R.id.no_data_text_view)).check(matches(not(isDisplayed())))
    }


    // Scenario 2: Favorite recipes are not present

    @Test
    fun testRecyclerViewIsNotDisplayed() {
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the RecyclerView is displayed
        onView(withId(R.id.favoriteRecipesRecyclerView)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testNoDataImageViewIsDisplayed() {
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the ImageView representing "no data" is displayed
        onView(withId(R.id.no_data_image_view)).check(matches(isDisplayed()))
    }

    @Test
    fun testNoDataTextViewIsDisplayed() {
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the TextView with the "no favorite recipes" message is displayed
        onView(withId(R.id.no_data_text_view)).check(matches(isDisplayed()))
    }

    // Scenario 1 and 2 depending on user input
    @Test
    fun testFavoritesPresent(){
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Scenario 1: Favorite recipes are present
        if(onView(withId(R.id.favoriteRecipesRecyclerView)).isDisplayed()) {
            // Verify that the ImageView representing "no data" is not displayed
            onView(withId(R.id.no_data_image_view)).check(matches(not(isDisplayed())))
            // Verify that the TextView with the "no favorite recipes" message is not displayed
            onView(withId(R.id.no_data_text_view)).check(matches(not(isDisplayed())))
        }
        // Scenario 2: Favorite recipes are not present
        else{
            // Verify that the ImageView representing "no data" is displayed
            onView(withId(R.id.no_data_image_view)).check(matches(isDisplayed()))
            // Verify that the TextView with the "no favorite recipes" message is displayed
            onView(withId(R.id.no_data_text_view)).check(matches(isDisplayed()))
        }
    }

    // Scenario 3: Deleting all favorite recipes
    @Test
    fun testDeleteAllFavorites(){
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Open the overflow menu in the app bar (click the three dots button)
        openActionBarOverflowOrOptionsMenu(context)
        // Click on the Delete All button
        onView(withText("Delete All"))
            .perform(click())
        // Check whether all favorite recipes are deleted
        onView(withId(R.id.no_data_image_view)).check(matches(isDisplayed()))
    }
}
