package com.example.myfood_kotlin.espresso_tests.recipes.details.favorite

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
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
import com.example.myfood_kotlin.espresso_tests.CommonFunctions
import org.junit.After

class AddToFavoritesEspressoTest : CommonFunctions() {

    // Scenario: adding favorite recipes
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun setUp() {
        deleteAll(context)
        // Go to recipes section
        Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
            .perform(ViewActions.click())
    }

    @Test
    fun testAddToFavorites(){
        // click on first recipe
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                    ViewActions.click()
                ))
        // click on the favorite button
        Espresso.onView(ViewMatchers.withId(R.id.save_to_favorites_menu))
            .perform(ViewActions.click())
        // check whether the right text is displayed
        Espresso.onView(ViewMatchers.withText("Recipe saved."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}
