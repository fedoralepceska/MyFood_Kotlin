package com.example.myfood_kotlin.automatortests

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FoodJokeTests {

    private lateinit var device: UiDevice

    @Before
    fun launchApp() {
        // Launch the app before each test
        val scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    fun testSeeFoodJokeScreen() {
        // Click on the view with id "foodJokeFragment"
        val foodJokeFragmentView = device.findObject(By.res("com.example.myfood_kotlin:id/foodJokeFragment"))
        foodJokeFragmentView.click()

        // Click on the view with id "food_joke_card_view"
        val foodJokeCardView = device.findObject(By.res("com.example.myfood_kotlin:id/food_joke_card_view"))
        foodJokeCardView.click()
    }

    @Test
    fun testShareFoodJoke() {
        // Click on the view with id "foodJokeFragment"
        val foodJokeFragmentView = device.findObject(By.res("com.example.myfood_kotlin:id/foodJokeFragment"))
        foodJokeFragmentView.click()

        Thread.sleep(500)

        // Click on the view with id "share_food_joke_menu"
        val shareFoodJokeMenu = device.findObject(By.res("com.example.myfood_kotlin:id/share_food_joke_menu"))
        shareFoodJokeMenu.click()

        Thread.sleep(500)

        // Check if "Share with Messages" text is visible
        val shareWithMessages = device.findObject(UiSelector().textContains("Share with Messages"))
        Assert.assertTrue(shareWithMessages.exists())
    }

    @Test
    fun testChangingJokes() {
        // Click on the view with id "foodJokeFragment"
        val foodJokeFragmentView = device.findObject(By.res("com.example.myfood_kotlin:id/foodJokeFragment"))
        foodJokeFragmentView.click()
        Thread.sleep(1000)

        // Capture the text of the joke when first visiting the "food joke" screen
        val firstJokeText = device.findObject(By.res("com.example.myfood_kotlin:id/food_joke_text_view")).text

        // Go to the "favorites" screen
        device.findObject(UiSelector().resourceId("com.example.myfood_kotlin:id/favoriteRecipesFragment")).click()


        // Return to the "food joke" screen
        foodJokeFragmentView.click()
        Thread.sleep(1000)

        // Capture the new text of the joke
        val newJokeText = device.findObject(By.res("com.example.myfood_kotlin:id/food_joke_text_view")).text

        // Verify that the new joke text is different from the previous one
        Assert.assertNotEquals(firstJokeText, newJokeText)
    }
}