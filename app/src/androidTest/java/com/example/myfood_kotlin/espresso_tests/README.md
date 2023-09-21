# Espresso testing tool

## Introduction

Espresso is a popular and powerful choice for testing the user interface (UI) of Android Kotlin applications. Espresso is a widely used testing framework for Android development, and it is specifically designed for UI testing. It provides a simple and concise API for interacting with your app's UI elements and verifying their behavior.

Here are some reasons why Espresso is a good choice for UI testing in Android Kotlin applications:

1. Integration with Android Studio: Espresso is well-integrated with Android Studio, making it easy to set up and run tests directly from your development environment.
2. UI Interaction: Espresso allows you to simulate user interactions, such as clicking buttons, entering text, and scrolling, which is crucial for testing the functionality and responsiveness of your app's UI.
3. Assertions: You can use Espresso to write assertions to verify that the UI behaves as expected. This includes checking the presence of specific UI elements, text content, and other properties.
4. Synchronization: Espresso automatically handles synchronization with the UI thread, ensuring that your tests run reliably even when dealing with asynchronous operations.
5. Readable and Maintainable Tests: Espresso tests can be written in a clear and readable manner, making it easier to create and maintain a suite of UI tests for your app.
6. Compatibility: Espresso works well with both Java and Kotlin, so you can use it in your Android Kotlin application without any issues.

However, keep in mind that while Espresso is a great choice for UI testing, it may not cover all aspects of testing your Android app. You may also want to consider other testing approaches like unit testing and integration testing to ensure comprehensive test coverage for your application.

In summary, Espresso is a recommended choice for UI testing in Android Kotlin applications due to its ease of use, integration with Android Studio, and capabilities for simulating user interactions and verifying UI behavior.

## Prerequisites

- You should have Android Studio installed on your machine.

## Installation

Note: Throughout this guide, we are assuming that you are testing a Kotlin Android application.

1. Open your app’s build.gradle file. This is usually not the top-level `build.gradle` file but `app/build.gradle`.

2. Add the following lines inside dependencies:
   `androidTestImplementation('androidx.test.espresso:espresso-core:3.4.0')`
   `androidTestImplementation('androidx.test:runner:1.4.0')`
   `androidTestImplementation('androidx.test:rules:1.4.0')`
   `androidTestImplementation 'androidx.test:rules:1.5.0'`

   You can also add the following dependencies, according to your needs.
   `androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.5.1'`
   `androidTestImplementation 'androidx.test.espresso:espresso-intents:3.5.1'`
   `androidTestImplementation 'androidx.fragment:fragment-testing:1.6.1'`

3. After you have included your dependencies, a 'Sync now' button will appear. Click it to sync your project with the gradle changes.

4. Add to the same build.gradle file the following line in `android.defaultConfig`:
   `testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"`

That's it!
For further explanations, refer to the official espresso [documentation](https://developer.android.com/training/testing/espresso/setup).

## Add your first test

1. Create your first espresso test class in com.example.your-application-name (androidTest)

   A good approach is to organize you espresso test classes in their own directory.
   The naming convention 'EspressoTest' suffix.

   Lets call the class `MyFirstEspressoTest`


2. Add the following test in your class.
    ```
    @RunWith(AndroidJUnit4::class)
    class MyFirstEspressoTest {
        @get:Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)
    
        @Test
        fun recyclerViewIsDisplayed() {
            onView(withId(R.Id.recyclerViewId)).check(matches(isDisplayed()))
        }
    }
    ```

3. Make sure to replace `recyclerViewId` with the id of an existing view in your application.

## Run your first test

1. Choose a device on which you will run the test. You can either choose emulator from the device manager or connect to a physical device.

   It is entirely up to your choice which device you will use, but please bear in mind that connecting to a physical device has additional steps.<br />


    * If your choice is to run your tests on physical device, then follow these steps:
        
        - Install ADB: If you haven't already, you need to install ADB on your computer. ADB is typically part of the Android SDK, but you can also install it separately.
        - Add ADB to the PATH
        - Run `adb` in cmd to test adb
        - Connect your Android physical device with usb
        - Enable developer options
        - Enable USB debugging
        <br />
        
    That should be it. If you are facing problems, there are many resources online. You can refer to this android [documentation](https://developer.android.com/studio/run/device).

2. Run the test by clicking the green triangle left to the test.<br /><br />
   Watch the application's behavior and monitor your test results.
   <br /><br /><br />Happy testing!
