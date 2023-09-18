package com.example.myfood_kotlin.automatortests

import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import com.example.myfood_kotlin.ui.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import androidx.test.uiautomator.UiDevice

class BottomSheetTests {

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
    fun testRecipesBottomSheetIsDisplayed() {
        // Click on the recipesBottomSheet (assuming it's a FloatingActionButton)
        val recipesFab = device.findObject(By.res("com.example.myfood_kotlin:id/recipes_fab"))
        recipesFab.click()

        // Verify that the Bottom sheet is displayed
        val mealTypeTxt = device.findObject(By.res("com.example.myfood_kotlin:id/mealType_txt"))
        Assert.assertNotNull(mealTypeTxt)
    }

    @Test
    fun testRecipesFilter() {
        val recipesFab = device.findObject(By.res("com.example.myfood_kotlin:id/recipes_fab"))
        recipesFab.click()

        val breadChipSelector = By.res("com.example.myfood_kotlin:id/bread_chip")
        device.wait(Until.findObject(breadChipSelector), 2000).click()

        val vegeChipSelector = By.res("com.example.myfood_kotlin:id/vegetarian_chip")
        device.wait(Until.findObject(vegeChipSelector), 2000).click()

        // Click on the apply button
        val applyBtn = device.findObject(By.res("com.example.myfood_kotlin:id/apply_btn"))
        applyBtn.click()
    }

    @Test
    fun testRecipesFilterAndCheckFirstRecipe() {
        // Apply the filters
        val recipesFab = device.findObject(By.res("com.example.myfood_kotlin:id/recipes_fab"))
        recipesFab.click()

        val breadChipSelector = By.res("com.example.myfood_kotlin:id/bread_chip")
        device.wait(Until.findObject(breadChipSelector), 2000).click()

        val vegeChipSelector = By.res("com.example.myfood_kotlin:id/vegetarian_chip")
        device.wait(Until.findObject(vegeChipSelector), 2000).click()

        // Click on the apply button
        val applyBtn = device.findObject(By.res("com.example.myfood_kotlin:id/apply_btn"))
        applyBtn.click()

        // Open the first recipe
        val firstRecipeLayout = device.findObject(By.res("com.example.myfood_kotlin:id/recipesRowLayout"))
        firstRecipeLayout.click()

        // Check if the recipe text contains "bread" and "vegetarian"
        val recipeText = device.findObject(UiSelector().textContains("bread").textContains("vegetarian"))
        Assert.assertTrue(recipeText.exists())
    }
}