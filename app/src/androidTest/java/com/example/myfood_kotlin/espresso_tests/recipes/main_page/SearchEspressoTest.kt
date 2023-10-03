package com.example.myfood_kotlin.espresso_tests.recipes.main_page

import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.espresso_tests.CommonFunctions
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchEspressoTest : CommonFunctions() {

//    Scenario: search recipes
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        // Click on the search button
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(ViewActions.click())
    }

    @Test
    fun testSearch(){
        // Input text
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_C))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_A))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_P))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_T))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_A))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_I))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_N))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_SPACE))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_A))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_M))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_E))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_R))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_I))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_C))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_A))
        // Press Enter to perform the search
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_ENTER))

        // Close the keyboard
        Espresso.onView(ViewMatchers.isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
            .perform(ViewActions.closeSoftKeyboard())

        Thread.sleep(5000)

        // Verify that the filter worked
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview)).checkItemCount(1)

    }

    @Test
    fun testSearchEdge(){
        // Input text
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_POUND))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_POUND))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_POUND))
        // Press Enter to perform the search
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(ViewActions.pressKey(KeyEvent.KEYCODE_ENTER))

        // Close the keyboard
        Espresso.onView(ViewMatchers.isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
            .perform(ViewActions.closeSoftKeyboard())

        // See manually whether the "Recipes not found." text is displayed
    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}