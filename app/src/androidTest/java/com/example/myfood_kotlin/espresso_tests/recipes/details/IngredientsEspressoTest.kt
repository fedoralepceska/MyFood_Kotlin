package com.example.myfood_kotlin.espresso_tests.recipes.details

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IngredientsEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        // click on first recipe
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                    ViewActions.click()
                ))
        // click on the ingredients button
        Espresso.onView(ViewMatchers.withText("Ingredients")).perform(ViewActions.click())
    }

    // Ingredients section
    @Test
    fun testIngredientsSection(){
        // check whether instructions section is displayed
        Espresso.onView(ViewMatchers.withId(R.id.ingredients_recyclerview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun testVerticalScroll() {
        // Scroll down
        Espresso.onView(ViewMatchers.withId(R.id.ingredients_recyclerview))
            .perform(ViewActions.scrollTo())
    }
}