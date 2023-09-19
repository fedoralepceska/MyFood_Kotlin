package com.example.myfood_kotlin.espresso_tests.recipes.bottomsheet

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import com.google.android.material.chip.Chip
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
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
        // Check display of element
        onView(allOf(withId(R.id.title_textView), withText("Berry Banana Breakfast Smoothie")))
            .check(matches(isDisplayed()))
    }

    @After
    fun tearDown(){
        activityRule.scenario.close()
    }
}
