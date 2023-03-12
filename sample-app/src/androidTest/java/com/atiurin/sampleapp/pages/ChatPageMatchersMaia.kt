package com.atiurin.sampleapp.pages
import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher

object ChatPageMatchersMaia {
    val inputMessageText: Matcher<View> by lazy { withId(R.id.message_input_text) }
    val sendMessageBtn: Matcher<View> by lazy { withId(R.id.send_button) }
    val messageText: Matcher<View> by lazy { withId(R.id.message_text) }
}
