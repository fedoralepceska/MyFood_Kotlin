package com.example.myfood_kotlin.espresso_tests.favorites

import android.content.Context
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.espresso_tests.CommonFunctions
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteRecipesEspressoTest : CommonFunctions() {

    // Scenario: Favorite recipes are present

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
    fun testViewsDisplay() {
        // Verify that the RecyclerView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesRecyclerView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // Verify that the ImageView representing "no data" is displayed
        Espresso.onView(ViewMatchers.withId(R.id.no_data_image_view)).check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))
        // Verify that the TextView with the "no favorite recipes" message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.no_data_text_view)).check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))

    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}
