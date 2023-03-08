package com.example.android.testing.espresso.BasicSample.Tests


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.android.testing.espresso.BasicSample.MainActivity
import com.example.android.testing.espresso.BasicSample.Page.Matchers
import com.example.android.testing.espresso.BasicSample.Steps.Actions
import com.example.android.testing.espresso.BasicSample.getText
import com.example.android.testing.espresso.BasicSample.tap
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextTests {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()
    val myText = "Maia Kikvadze"

    @Test
    fun changeText() {

        with(Matchers) {
            Actions.changeActionStep(myText)
            changeTextButton.tap()
            Assert.assertEquals(myText, textTobeCanged.getText())
        }
    }
    @Test
    fun openActivityChangeText() {

        with(Matchers) {
            Actions.openActivityStep(myText)
            openActivityButton.tap()
            onView(withText(myText)).check(matches(isDisplayed()))
        }
    }

}