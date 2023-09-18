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

class AddToFavoritesEspressoTest {

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
        // Delete all favorites if present
        if(Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesRecyclerView)).isDisplayed()) {
            // Open the overflow menu in the app bar (click the three dots button)
            Espresso.openActionBarOverflowOrOptionsMenu(context)
            // Click on the Delete All button
            Espresso.onView(ViewMatchers.withText("Delete All"))
                .perform(ViewActions.click())
            // Wait for the snackBar to close
            Thread.sleep(5000)
            // Go to recipes section
            Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
                .perform(ViewActions.click())
        }
    }

    @Test
    fun testAddToFavorites(){
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
        Espresso.onView(ViewMatchers.withText("Recipe saved."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}