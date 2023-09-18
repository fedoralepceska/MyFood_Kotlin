package com.example.myfood_kotlin.espresso_tests.favorites

import android.content.Context
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NoFavoritesRecipesEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    // Scenario 2: Favorite recipes are not present

    @Before
    fun setUp(){
        // Click on the favorites button
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
        // Open the overflow menu in the app bar (click the three dots button)
        Espresso.openActionBarOverflowOrOptionsMenu(context)
        // Click on the Delete All button
        Espresso.onView(ViewMatchers.withText("Delete All"))
            .perform(ViewActions.click())
        // Go back to favorites
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
    }

    @Test
    fun testRecyclerViewIsNotDisplayed() {
        // Verify that the RecyclerView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesRecyclerView))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun testNoDataImageViewIsDisplayed() {
        // Verify that the ImageView representing "no data" is displayed
        Espresso.onView(ViewMatchers.withId(R.id.no_data_image_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testNoDataTextViewIsDisplayed() {
        // Verify that the TextView with the "no favorite recipes" message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.no_data_text_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
