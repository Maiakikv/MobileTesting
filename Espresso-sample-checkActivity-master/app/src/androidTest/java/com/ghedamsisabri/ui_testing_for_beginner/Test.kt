package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class Test {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkSecondPage() {
        NextBtn.tap()
        secondPageActivity.isViewDisplayed()
        BackBtn.isViewDisplayed()

        isTextOnScreen("SecondaryActivity")
        Assert.assertEquals("SecondaryActivity", secondPageActivity.getText(5))
    }

    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val BackBtn: Matcher<View> by lazy { withId(R.id.button_back) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
    }
}