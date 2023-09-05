package com.example.myfood_kotlin.espressotests

import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myfood_kotlin.R
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBottomNavigationButtons() {
        onView(withId(R.id.recipesFragment))
            .perform(click())
        onView(withId(R.id.favoriteRecipesFragment))
            .perform(click())
        onView(withId(R.id.foodJokeFragment))
            .perform(click())
    }

}