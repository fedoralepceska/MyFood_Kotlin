package com.example.myfood_kotlin.espresso_tests.recipes.main_page

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.espresso_tests.CommonFunctions
import com.example.myfood_kotlin.ui.MainActivity
import org.hamcrest.CoreMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipesEspressoTest : CommonFunctions() {

    // Scenario: recipes display and scroll

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        // Click on recipes button
        Espresso.onView(ViewMatchers.withId(R.id.recipesFragment))
            .perform(ViewActions.click())
    }

    @Test
    fun testRecyclerViewIsDisplayed(){
        // Verify that the RecyclerView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testVerticalScroll(){
        Thread.sleep(3000)
        // Scroll down
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}