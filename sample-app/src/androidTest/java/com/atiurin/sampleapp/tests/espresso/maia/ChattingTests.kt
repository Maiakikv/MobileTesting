
package com.atiurin.sampleapp.tests.maia

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.R
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.data.MyData
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.pages.ChatPageMatchersMaia
import com.atiurin.sampleapp.pages.FriendsPageMatchersMaia
import com.atiurin.sampleapp.steps.Actions
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTestsMaia {
    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun chatWithEmmetBrownTest() {
        with(FriendsPageMatchersMaia) {
            Actions.scrollToFriend("Emmet Brown")
            Actions.openChatStep("Emmet Brown")
            ChatPageMatchersMaia.inputMessageText.isViewDisplayed()
            Actions.enterAndSendTextStep(MyData.drinkText)

            Actions.assertion(MyData.drinkText)
        }
    }
    @Test
    fun chatWithNamelessFriendTest() {
        with(FriendsPageMatchersMaia) {
            Actions.scrollToFriend("Friend17")
            Actions.openChatStep("Friend17")
            ChatPageMatchersMaia.inputMessageText.isViewDisplayed()
            Actions.enterAndSendTextStep(MyData.changeNameText)

            Actions.assertion(MyData.changeNameText)
        }
    }


}