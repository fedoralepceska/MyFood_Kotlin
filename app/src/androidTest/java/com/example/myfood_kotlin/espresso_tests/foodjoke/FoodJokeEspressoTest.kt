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

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Scenario 1: Food joke is displayed on screen
    @Test
    fun testRecyclerViewIsDisplayed(){
        // Click on the food joke button
        onView(withId(R.id.foodJokeFragment))
            .perform(click())
        // Verify that the food joke text view is displayed
        onView(withId(R.id.food_joke_text_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Scenario 2: Share button works
    @Test
    fun testShareFoodJokeButton(){
        // Click on the food joke button
        onView(withId(R.id.foodJokeFragment))
            .perform(click())
        // Click on the share button
        onView(withId(R.id.share_food_joke_menu))
            .perform(click())
        // Verify that share menu is opened
        onView(withId(R.id.food_joke_text_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}