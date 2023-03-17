package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object FriendsPageMatchersMaia {
    val Chandler: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Chandler Bing")) }
    val Ross: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Ross Geller")) }
    val Rachel: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Rachel Green")) }
    val Phoebe: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Phoebe Buffay")) }
    val Monica: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Monica Geller")) }
    val Gunther: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Gunther")) }
    val Janice: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), ViewMatchers.withText("Janice")) }
}