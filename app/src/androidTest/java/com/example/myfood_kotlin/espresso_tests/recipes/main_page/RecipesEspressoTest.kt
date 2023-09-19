package com.example.myfood_kotlin.espresso_tests.recipes.main_page

import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.hamcrest.CoreMatchers.*
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipesEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    fun ViewInteraction.checkItemCount(expectedCount: Int) {
        check { view, noViewFoundException ->
            if (noViewFoundException != null) {
                throw noViewFoundException
            }

            val recyclerView = view as RecyclerView
            val adapter = recyclerView.adapter
            assertThat(adapter?.itemCount, `is`(expectedCount))
        }
    }

    @Test
    fun testRecyclerViewIsDisplayed(){
        // Click on recipes button
        Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
            .perform(click())
        // Verify that the RecyclerView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    // Scenario 2: Search recipes

    @Test
    fun testSearch(){
        // Click on the search button
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(click())
        // Input text
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(pressKey(KeyEvent.KEYCODE_C))
            .perform(pressKey(KeyEvent.KEYCODE_A))
            .perform(pressKey(KeyEvent.KEYCODE_P))
            .perform(pressKey(KeyEvent.KEYCODE_T))
            .perform(pressKey(KeyEvent.KEYCODE_A))
            .perform(pressKey(KeyEvent.KEYCODE_I))
            .perform(pressKey(KeyEvent.KEYCODE_N))
            .perform(pressKey(KeyEvent.KEYCODE_SPACE))
            .perform(pressKey(KeyEvent.KEYCODE_A))
            .perform(pressKey(KeyEvent.KEYCODE_M))
            .perform(pressKey(KeyEvent.KEYCODE_E))
            .perform(pressKey(KeyEvent.KEYCODE_R))
            .perform(pressKey(KeyEvent.KEYCODE_I))
            .perform(pressKey(KeyEvent.KEYCODE_C))
            .perform(pressKey(KeyEvent.KEYCODE_A))
        // Press Enter to perform the search
        Espresso.onView(ViewMatchers.withId(R.id.menu_search))
            .perform(pressKey(KeyEvent.KEYCODE_ENTER))

        // Close the keyboard
        Espresso.onView(isAssignableFrom(androidx.appcompat.widget.SearchView::class.java))
            .perform(closeSoftKeyboard())

        Thread.sleep(5000)

        // Verify that the filter worked
//        Espresso.onView(
//            allOf(
//                ViewMatchers.withId(R.id.title_textView),
//                ViewMatchers.withText("Berry Banana Breakfast Smoothie")
//            )
//        )
//            .check(matches(not(ViewMatchers.isDisplayed())))
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview)).checkItemCount(1)

    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}