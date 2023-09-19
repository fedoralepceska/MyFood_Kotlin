package com.example.myfood_kotlin.espresso_tests.recipes.details

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OverviewEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        // click on first recipe
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }
    @Test
    fun testOpeningRecipe(){
        // check whether the correct recipe is displayed
        Espresso.onView(ViewMatchers.withId(R.id.title_textView))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testVerticalScroll() {
        // Scroll down
        Espresso.onView(ViewMatchers.withId(R.id.scrollView2))
            .perform(ViewActions.scrollTo())
    }

}