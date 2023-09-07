package com.example.myfood_kotlin.espresso_tests.navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class NavigationEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBottomNavigationMenu(){
        // Verify that the Recipes page is displayed
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()))
        // Click on the favorites button
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        // Verify that the Favorites page is displayed
        onView(withId(R.id.favoriteRecipesRecyclerView)).check(matches(isDisplayed()))
        // Click on the recipes button
        onView(withId(R.id.recipesFragment))
            .perform(click())
        // Verify that the Recipes page is displayed
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()))
        // Click on the food joke button
        onView(withId(R.id.foodJokeFragment))
            .perform(click())
        Thread.sleep(2000)
        // Verify that the Food joke page is displayed
        onView(withId(R.id.food_joke_text_view)).check(matches(isDisplayed()))
    }
}