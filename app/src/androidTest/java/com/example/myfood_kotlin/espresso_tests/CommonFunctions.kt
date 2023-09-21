package com.example.myfood_kotlin.espresso_tests

import android.R
import android.content.res.Resources.NotFoundException
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.MenuItem
import android.widget.Button
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.runner.RunWith
import android.content.Context

@RunWith(AndroidJUnit4::class)
open class CommonFunctions {

    fun deleteAll(context: Context){
        // Go to favorites section
        Espresso.onView(ViewMatchers.withId(com.example.myfood_kotlin.R.id.favoriteRecipesFragment))
            .perform(ViewActions.click())
        // Open the overflow menu in the app bar (click the three dots button)
        Espresso.openActionBarOverflowOrOptionsMenu(context)
        // Click on the Delete All button
        Espresso.onView(ViewMatchers.withText("Delete All"))
            .perform(ViewActions.click())
        // Wait for the snackBar to close
        Thread.sleep(5000)
    }

    fun deleteAllAddFirst(context: Context){
        deleteAll(context)
        // Go to recipes section
        Espresso.onView(ViewMatchers.withId(com.example.myfood_kotlin.R.id.recipesFragment))
            .perform(ViewActions.click())
        // Click on first recipe
        Espresso.onView(ViewMatchers.withId(com.example.myfood_kotlin.R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        // Click on the favorite button
        Espresso.onView(ViewMatchers.withId(com.example.myfood_kotlin.R.id.save_to_favorites_menu))
            .perform(ViewActions.click())
        Thread.sleep(5000)
    }

    fun ViewInteraction.checkItemCount(expectedCount: Int) {
        check { view, noViewFoundException ->
            if (noViewFoundException != null) {
                throw noViewFoundException
            }

            val recyclerView = view as RecyclerView
            val adapter = recyclerView.adapter
            ViewMatchers.assertThat(adapter?.itemCount, CoreMatchers.`is`(expectedCount))
        }
    }

//    fun ViewInteraction.isDisplayed(): Boolean {
//        return try {
//            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }

    // check button state by action view
//    fun isChecked(menuItemId: Int): Boolean {
//        var isChecked = false
//
//        // Use Espresso to check the menu item
//        Espresso.onView(ViewMatchers.withId(menuItemId))
//            .check { view, _ ->
//                if (view is MenuItem) {
//                    isChecked = view.isActionViewExpanded
//                }
//            }
//
//        return isChecked
//    }

//    fun isViewChecked(viewId: Int): Boolean {
//        val isChecked: Boolean = try {
//            Espresso.onView(ViewMatchers.withId(viewId)).check(ViewAssertions.matches(ViewMatchers.isChecked()))
//            true
//        } catch (e: NoMatchingViewException) {
//            // View not found or not checked
//            false
//        }
//        return isChecked
//    }

    // check button state by color
//    fun isCheckedByColor(buttonId: Int): Boolean {
//        var isChecked = false
//
//        val viewInteraction = Espresso.onView(ViewMatchers.withId(buttonId))
//        viewInteraction.check { view, _ ->
//            if (view is Button) {
//                val buttonBackground: Drawable = view.background
//
//                val expectedColor = ContextCompat.getColor(view.context, Color.YELLOW)
//                val colorDrawable = buttonBackground as? ColorDrawable
//
//                if (colorDrawable != null && colorDrawable.color == expectedColor) {
//                    isChecked = true
//                }
//            }
//        }
//
//        return isChecked
//    }

//    fun isNotCheckedByColor(buttonId: Int): Boolean {
//        var isChecked = true
//
//        val viewInteraction = Espresso.onView(ViewMatchers.withId(buttonId))
//        viewInteraction.check { view, _ ->
//            if (view is Button) {
//                val buttonBackground: Drawable = view.background
//
//                // Get the color resource for white
//                val whiteColorResource = R.color.white
//                val whiteColor = ContextCompat.getColor(view.context, whiteColorResource)
//
//                // Get the color resource for black
//                val blackColorResource = R.color.black
//                val blackColor = ContextCompat.getColor(view.context, blackColorResource)
//
//
//                val colorDrawable = buttonBackground as? ColorDrawable
//
//
//                if (colorDrawable != null && (colorDrawable.color == whiteColor || colorDrawable.color == blackColor)) {
//                    isChecked = false
//                }
//            }
//        }
//
//        return isChecked
//    }

//    val isButtonChecked = try {
//        Espresso.onView(ViewMatchers.withId(com.example.myfood_kotlin.R.id.save_to_favorites_menu))
//            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
//        true
//    } catch (e: NoMatchingViewException) {
//        false
//    }
}
