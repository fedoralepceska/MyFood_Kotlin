package com.example.myfood_kotlin.espresso_tests.favorites

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.espresso_tests.CommonFunctions
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeleteFavoriteRecipesEspressoTest : CommonFunctions(){

    // Scenario: deleting favorite recipes
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun setUp(){
        deleteAllAddFirst(context)
        // Perform the pressBack action
        Espresso.pressBack()
        // Go back to favorites section
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
    }

    @Test
    fun testDeleteAllFavorites(){
        // Open the overflow menu in the app bar (click the three dots button)
        Espresso.openActionBarOverflowOrOptionsMenu(context)
        // Click on the Delete All button
        Espresso.onView(ViewMatchers.withText("Delete All"))
            .perform(ViewActions.click())
        // Check whether all favorite recipes are deleted
        Espresso.onView(ViewMatchers.withId(R.id.no_data_image_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFirstRecipeDelete(){
        // click on the first recipe
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                    ViewActions.click()
                ))
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
