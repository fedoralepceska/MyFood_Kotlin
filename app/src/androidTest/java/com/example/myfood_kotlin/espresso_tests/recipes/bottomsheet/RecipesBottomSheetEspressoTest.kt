package com.example.myfood_kotlin.espresso_tests.recipes.bottomsheet

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RecipesBottomSheetEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        // Click on the recipesBottomSheet
        onView(withId(R.id.recipes_fab))
            .perform(click())
    }

    // Scenario 1: Display bottom sheet

    @Test
    fun testRecipesBottomSheetIsDisplayed(){
        // Verify that the Bottom sheet is displayed
        onView(withId(R.id.mealType_txt))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    // Scenario 2: Applying filters to recipes

    @Test
    fun testRecipesFilter(){
        // Scroll meal types and select drinks
        onView(withId(R.id.drink_chip))
            .perform(ViewActions.scrollTo()).perform(click())
        // Scroll diet types and select vegetarian
        onView(withId(R.id.vegetarian_chip))
            .perform(ViewActions.scrollTo()).perform(click())
        onView(withId(R.id.apply_btn))
            .perform(click())
    }
}