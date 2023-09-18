package com.example.myfood_kotlin.espresso_tests.favorites

import android.content.Context
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeleteAllFavoriteRecipesEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Obtain a reference to the application's context for the delete all test
    private val context: Context = InstrumentationRegistry.getInstrumentation().context

    // Scenario 3: Delete all favorite recipes

    @Test
    fun testDeleteAllFavorites(){
        // Click on the favorites button
        Espresso.onView(ViewMatchers.withId(R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
        // Open the overflow menu in the app bar (click the three dots button)
        Espresso.openActionBarOverflowOrOptionsMenu(context)
        // Click on the Delete All button
        Espresso.onView(ViewMatchers.withText("Delete All"))
            .perform(ViewActions.click())
        // Check whether all favorite recipes are deleted
        Espresso.onView(ViewMatchers.withId(R.id.no_data_image_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
