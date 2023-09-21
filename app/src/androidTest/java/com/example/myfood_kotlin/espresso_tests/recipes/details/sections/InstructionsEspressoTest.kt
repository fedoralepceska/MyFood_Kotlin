package com.example.myfood_kotlin.espresso_tests.recipes.details.sections

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class InstructionsEspressoTest {

    // Scenario: instructions web view display

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testInstructionsSection(){
        // click on first recipe
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                    ViewActions.click()
                ))
        // click on the instructions button
        Espresso.onView(ViewMatchers.withText("Instructions")).perform(ViewActions.click())
        // check whether instructions section is displayed
        Espresso.onView(ViewMatchers.withId(R.id.instructions_web_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}