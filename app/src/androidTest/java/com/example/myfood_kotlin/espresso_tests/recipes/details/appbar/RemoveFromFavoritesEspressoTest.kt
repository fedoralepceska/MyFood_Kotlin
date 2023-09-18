package com.example.myfood_kotlin.espresso_tests.recipes.details.appbar

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RemoveFromFavoritesEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    fun ViewInteraction.isDisplayed(): Boolean {
        try {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            return true
        } catch (e: NoMatchingViewException) {
            return false
        }
    }

    @Before
    fun setUp(){
        // Go to favorites section
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())

        // Add favorite recipe if there are none
        if(!Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesRecyclerView)).isDisplayed()){
            // Go to recipes section
            Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
                .perform(ViewActions.click())
            // click on first recipe
            Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                        ViewActions.click()
                    ))
            // click on the favorites button
            Espresso.onView(ViewMatchers.withId(R.id.save_to_favorites_menu))
                .perform(ViewActions.click())
            Thread.sleep(5000)
            // Go back
            Espresso.pressBack()
            // Go to recipes section
            Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
                .perform(ViewActions.click())
        }
        else {
            // Go to recipes section
            Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
                .perform(ViewActions.click())
        }
    }
    // Scenario 2: remove from favorites
    @Test
    fun testRemoveFromFavorites(){
        // click on first recipe
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                    ViewActions.click()
                ))
        // click on the favorites button
        Espresso.onView(ViewMatchers.withId(R.id.save_to_favorites_menu))
            .perform(ViewActions.click())

        // check whether the right text is displayed
        Espresso.onView(ViewMatchers.withText("Removed from Favorites."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}