package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.atiurin.sampleapp.R
import com.atiurin.sampleapp.data.MyData
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.swiper
import com.atiurin.sampleapp.pages.ChatPageMatchersMaia
import com.atiurin.sampleapp.pages.FriendsPageMatchersMaia
import com.atiurin.ultron.extensions.tap
import com.atiurin.ultron.extensions.typeText
import org.hamcrest.Matchers

object Actions {
    fun openChatStep(friendName: String) {
        Matchers.allOf(ViewMatchers.withId(R.id.tv_name), ViewMatchers.withText(friendName)).tap()


    }
    fun enterAndSendTextStep(text: String) {
        ChatPageMatchersMaia.inputMessageText.typeText(text)
        ChatPageMatchersMaia.sendMessageBtn.tap()
    }

    fun swipe(){
        swiper(350, 200, 5)
    }

    fun scrollToFriend(friendName: String){
       while (!Matchers.allOf(ViewMatchers.withId(R.id.tv_name), ViewMatchers.withText(friendName)).isViewDisplayed())
            swipe()
    }

    fun assertion (text: String){
        val textView: ViewInteraction =
            Espresso.onView(
                Matchers.allOf(
                    ViewMatchers.withId(R.id.message_text),
                    ViewMatchers.withText(text)
                )
            )
        textView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
