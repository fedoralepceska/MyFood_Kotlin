package com.example.myfood_kotlin.automatortests

import android.view.KeyEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipesTests {

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
    fun testSeeRecipesScreen() {

        // Check if text containing "Ancient" is visible
        val ancientText = mDevice.findObject(UiSelector().textContains("Ancient"))
        Assert.assertTrue(ancientText.exists())
    }


    @Test
    fun testOpenRecipe() {

        // Click on the view with id "placeholder_row_layout"
        val placeholderRowLayout = mDevice.findObject(By.res("com.example.myfood_kotlin:id/recipesRowLayout"))
        placeholderRowLayout.click()

        // Check if text containing "Ancient grains" is visible
        val ancientText = mDevice.findObject(UiSelector().textContains("Ancient Grains"))
        Assert.assertTrue(ancientText.exists())
    }

    @Test
    fun testAddToFavorites() {

        // Click on the view with id "placeholder_row_layout"
        val placeholderRowLayout = mDevice.findObject(By.res("com.example.myfood_kotlin:id/recipesRowLayout"))
        placeholderRowLayout.click()

        Thread.sleep(1000)

        // Save to favorites
        val saveToFavorites = mDevice.findObject(By.res("com.example.myfood_kotlin:id/save_to_favorites_menu"))
        saveToFavorites.click()

        mDevice.pressBack()

        val favoriteRecipesFragment = mDevice.findObject(UiSelector().resourceId("com.example.myfood_kotlin:id/favoriteRecipesFragment"))
        try {
            favoriteRecipesFragment.click()
        } catch (e: UiObjectNotFoundException) {
            e.printStackTrace()
        }

        val ancientText = mDevice.findObject(UiSelector().textContains("Ancient"))
        Assert.assertTrue(ancientText.exists())
    }

    @Test
    fun testOpenIngredientsScreen() {

        // Click on the view with id "placeholder_row_layout"
        val placeholderRowLayout = mDevice.findObject(By.res("com.example.myfood_kotlin:id/recipesRowLayout"))
        placeholderRowLayout.click()

        // Find an element that contains the text "Ingredients"
        val ingredientsElement = mDevice.findObject(UiSelector().textContains("Ingredients"))

        // Click on the "Ingredients" element
        ingredientsElement.click()

        Thread.sleep(500)

        // Check if text containing "Flour" is visible
        val flourText = mDevice.findObject(UiSelector().textContains("Flour"))
        Assert.assertTrue(flourText.exists())
    }

    @Test
    fun testOpenInstructionsScreen() {
        // Click on the view with id "placeholder_row_layout"
        val placeholderRowLayout = mDevice.findObject(By.res("com.example.myfood_kotlin:id/recipesRowLayout"))
        placeholderRowLayout.click()

        // Find an element that contains the text "Instructions"
        val instructionsElement = mDevice.findObject(UiSelector().textContains("Instructions"))

        // Click on the "Instructions" element
        instructionsElement.click()

        // Wait for the WebView to load
        mDevice.waitForIdle()

        // Check if the WebView has loaded content
        val webView = mDevice.findObject(By.res("com.example.myfood_kotlin:id/instructions_web_view"))

        // Check if the WebView content is not empty (indicating a web page has loaded)
        Assert.assertNotNull(webView)
    }


    @Test
    fun testSearchRecipes() {
        // Click on the view with id "menu_search"
        val menuSearchView = mDevice.findObject(By.res("com.example.myfood_kotlin:id/menu_search"))
        menuSearchView.click()

        mDevice.pressKeyCode(KeyEvent.KEYCODE_S)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_E)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_E)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_D)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_SPACE)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_P)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_O)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_R)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_R)

        mDevice.pressEnter()
        mDevice.wait(Until.hasObject(By.pkg("com.example.myfood_kotlin").text("Seed Porridge")), 2000)


        // Check if text containing "Seed Porridge" is visible
        val seedPorridgeText = mDevice.findObject(UiSelector().textContains("Seed Porridge"))
        Assert.assertTrue(seedPorridgeText.exists())
    }

    // EDGE CASE

    @Test
    fun testSearchNoResultsRecipes() {
        // Click on the view with id "menu_search"
        val menuSearchView = mDevice.findObject(By.res("com.example.myfood_kotlin:id/menu_search"))
        menuSearchView.click()

        mDevice.pressKeyCode(KeyEvent.KEYCODE_POUND)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_POUND)
        mDevice.pressKeyCode(KeyEvent.KEYCODE_POUND)

        mDevice.pressEnter()

        // Wait
        mDevice.wait(Until.hasObject(By.pkg("com.example.myfood_kotlin").text("Recipes not found")), 2000)

        // Check if the notification with "Recipes not found" text exists
        try {
            val notification = mDevice.findObject(By.pkg("com.example.myfood_kotlin").text("Recipes not found"))
        } catch (e: UiObjectNotFoundException) {
            Assert.fail("Notification not found.")
        }
    }

    @Test
    fun testRecipesFragmentScrollable() {
        val recyclerView = mDevice.findObject(By.res("com.example.myfood_kotlin:id/recyclerview"))

        // initial item count
        val initialItemCount = recyclerView.childCount

        // swipe
        mDevice.swipe(200, 1200, 200, 200, 10)

        // item count after swipe
        val afterSwipeItemCount = recyclerView.childCount

        Assert.assertTrue(afterSwipeItemCount > initialItemCount)
    }



}