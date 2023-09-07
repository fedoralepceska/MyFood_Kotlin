package com.example.myfood_kotlin.espresso_tests.recipes.main_page

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class RecipesEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Scenario 1: The recipes page is shown after clicking recipes button

    @Test
    fun testRecyclerViewIsDisplayed(){
        // Click on recipes button
        onView(withId(R.id.recipesFragment))
            .perform(click())
        // Verify that the RecyclerView is displayed
        onView(withId(R.id.recyclerview))
            .check(matches(ViewMatchers.isDisplayed()))
    }


    // Scenario 2: Search recipes

//    TODO (optional): find how to input text through keyboard

    @Test
    fun testSearch(){
        // Click the search button
        onView(withId(R.id.menu_search))
            .perform(click())
//        Thread.sleep(2000)
//        // Enter text into the SearchView (doesn't work)
//        onView(ViewMatchers.isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
//            .perform(ViewActions.typeText("Captain america"))
        // Close the keyboard
        onView(ViewMatchers.isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
            .perform(ViewActions.closeSoftKeyboard())
//        // Perform a search action (e.g., press the "Search" button on the keyboard)
//        onView(ViewMatchers.isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
//            .perform(ViewActions.pressImeActionButton())
    }
}