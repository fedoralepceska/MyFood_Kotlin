package com.example.myfood_kotlin.espresso_tests.recipes.bottomsheet

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipesBottomSheetEspressoTest {

    // Scenario: Filtering recipes through bottom sheet

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        // Click on the recipesBottomSheet
        Espresso.onView(ViewMatchers.withId(R.id.recipes_fab))
            .perform(click())
    }

    @Test
    fun testRecipesBottomSheetIsDisplayed(){
        // Verify that the Bottom sheet is displayed
        Espresso.onView(ViewMatchers.withId(R.id.mealType_txt))
            .check(matches(ViewMatchers.isDisplayed()))
        // Close the bottom sheet
        Espresso.onView(ViewMatchers.withId(R.id.apply_btn))
            .perform(click())
    }

    @Test
    fun testRecipesFilter(){
        // Scroll meal types and select drinks
        Espresso.onView(ViewMatchers.withId(R.id.drink_chip))
            .perform(ViewActions.scrollTo()).perform(click())
        // Scroll diet types and select vegetarian
        Espresso.onView(ViewMatchers.withId(R.id.vegetarian_chip))
            .perform(ViewActions.scrollTo()).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.apply_btn))
            .perform(click())
        // See manually whether layout changes
    }

    @After
    fun tearDown(){
        // Click on the recipesBottomSheet
        Espresso.onView(ViewMatchers.withId(R.id.recipes_fab))
            .perform(click())
        // Scroll meal types and select drinks
        Espresso.onView(ViewMatchers.withId(R.id.main_course_chip))
            .perform(ViewActions.scrollTo()).perform(click())
        // Scroll diet types and select vegetarian
        Espresso.onView(ViewMatchers.withId(R.id.gluten_free_chip))
            .perform(ViewActions.scrollTo()).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.apply_btn))
            .perform(click())
        activityRule.scenario.close()
    }
}
