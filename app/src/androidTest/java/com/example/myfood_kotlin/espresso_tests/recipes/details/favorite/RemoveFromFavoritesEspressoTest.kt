package com.example.myfood_kotlin.espresso_tests.recipes.details.favorite

import android.content.Context
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.espresso_tests.CommonFunctions
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RemoveFromFavoritesEspressoTest : CommonFunctions(){

    // Scenario: removing favorite recipes through recipes section

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun setUp(){
        deleteAllAddFirst(context)
    }

    @Test
    fun testRemoveFromFavorites(){
        // click on the favorite button
        Espresso.onView(ViewMatchers.withId(R.id.save_to_favorites_menu))
            .perform(ViewActions.click())
        // check whether the right text is displayed
        Espresso.onView(ViewMatchers.withText("Removed from Favorites."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}
