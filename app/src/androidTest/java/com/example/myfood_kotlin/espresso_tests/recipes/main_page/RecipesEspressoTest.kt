package com.example.myfood_kotlin.espresso_tests.recipes.main_page

import android.provider.Settings.Global.getString
import android.view.KeyEvent
import android.widget.SearchView
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
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
//        onView(withId(R.id.menu_search))
//            .perform(typeText("Captain America"), pressKey(KeyEvent.KEYCODE_ENTER))

        // Click the search button
        onView(withId(R.id.menu_search))
            .perform(click())
//        Thread.sleep(2000)
//        // Enter text into the SearchView (doesn't work)
//        onView(isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
//            .perform(typeText("Captain america"))
//        onView(isAssignableFrom(SearchView::class.java))
//            .perform(typeText("Captain America"), pressKey(KeyEvent.KEYCODE_ENTER))
        // Close the keyboard
        onView(isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
            .perform(closeSoftKeyboard())
//        // Perform a search action (e.g., press the "Search" button on the keyboard)
//        onView(ViewMatchers.isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
//            .perform(ViewActions.pressImeActionButton())
    }

//    @Test
//    fun testSearch2(){
//        // Open the SearchView
//        onView(withId(R.id.menu_search)).perform(click())
//
//// Type text into the SearchView
//        onView(withId(R.id.search_src_text)).perform(typeText("Captain America"))
//
//// Press Enter to perform the search
//        onView(withId(R.id.search_src_text)).perform(pressKey(KeyEvent.KEYCODE_ENTER))
//
//    }
}