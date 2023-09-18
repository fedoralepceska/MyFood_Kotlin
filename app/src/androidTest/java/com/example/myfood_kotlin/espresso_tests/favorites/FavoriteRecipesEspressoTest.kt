package com.example.myfood_kotlin.espresso_tests.favorites

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteRecipesEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    // Scenario 1: Favorite recipes are present

    @Before
    fun setUp(){
        // Go to favorites section
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
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
        // Click on first recipe
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        // Click on the favorite button
        Espresso.onView(ViewMatchers.withId(R.id.save_to_favorites_menu))
            .perform(ViewActions.click())
        Thread.sleep(5000)
        // Perform the pressBack action
        Espresso.pressBack()
        // Go back to favorites section
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
    }

    @Test
    fun testRecyclerViewIsDisplayed() {
        // Verify that the RecyclerView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesRecyclerView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testNoDataImageViewIsNotDisplayed() {
        // Verify that the ImageView representing "no data" is displayed
        Espresso.onView(ViewMatchers.withId(R.id.no_data_image_view)).check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun testNoDataTextViewIsNotDisplayed() {
        // Verify that the TextView with the "no favorite recipes" message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.no_data_text_view)).check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))
    }
}
