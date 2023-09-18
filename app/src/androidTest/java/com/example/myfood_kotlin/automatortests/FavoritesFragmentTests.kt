package com.example.myfood_kotlin.automatortests

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObjectNotFoundException
import androidx.test.uiautomator.UiSelector
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoritesFragmentTests {

    private lateinit var mDevice: UiDevice

    @Before
    fun launchApp() {
        // Launch the app before each test
        val scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Before
    fun setUp() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    fun testFavoriteRecipesScreen() {
        // Find and click the view with the ID "favoriteRecipesFragment"
        val favoriteRecipesFragment = mDevice.findObject(UiSelector().resourceId("com.example.myfood_kotlin:id/favoriteRecipesFragment"))
        try {
            favoriteRecipesFragment.click()
        } catch (e: UiObjectNotFoundException) {
            e.printStackTrace()
        }

        // Verify that the screen displays text containing "No Favorite Recipes"
        val noFavoriteRecipesText = mDevice.findObject(UiSelector().textContains("No Favorite Recipes"))
        Assert.assertTrue(
            "No Favorite Recipes text is not displayed",
            noFavoriteRecipesText.exists()
        )
    }

    @Test
    @Throws(UiObjectNotFoundException::class)
    fun deleteAllFavorites() {
        // Open the action bar overflow menu or options menu
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        // Find and click the view with the ID "favoriteRecipesFragment"
        val favoriteRecipesFragment = mDevice.findObject(UiSelector().resourceId("com.example.myfood_kotlin:id/favoriteRecipesFragment"))
        try {
            favoriteRecipesFragment.click()
        } catch (e: UiObjectNotFoundException) {
            e.printStackTrace()
        }

        device.pressMenu()

        // Find the "Delete All" option and click it
        val deleteAllOption = device.findObject(UiSelector().text("Delete All"))
        if (deleteAllOption.exists() && deleteAllOption.isClickable) {
            deleteAllOption.click()
        }

        Thread.sleep(2000)

        try {
            val notification = mDevice.findObject(By.pkg("com.example.myfood_kotlin").text("All recipes removed"))
        } catch (e: UiObjectNotFoundException) {
            Assert.fail("Notification not found.")
        }
    }


}