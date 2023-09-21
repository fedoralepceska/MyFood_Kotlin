package com.example.myfood_kotlin.espresso_tests.foodjoke

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Test
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule

class FoodJokeEspressoTest {

    // Scenario: Food joke display and share
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewIsDisplayed(){
        // Click on the food joke button
        onView(withId(R.id.foodJokeFragment))
            .perform(click())
        Thread.sleep(2000)
        // Verify that the food joke text view is displayed
        onView(withId(R.id.food_joke_text_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testShareFoodJokeButton(){
        // Click on the food joke button
        onView(withId(R.id.foodJokeFragment))
            .perform(click())
        // Click on the share button
        onView(withId(R.id.share_food_joke_menu))
            .perform(click())
        // See manually the pop up of share options (system level element)
    }
}