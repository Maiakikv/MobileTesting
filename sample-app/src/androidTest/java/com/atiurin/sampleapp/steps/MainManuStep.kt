package com.atiurin.sampleapp.steps

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher

object MainManuStep {

    fun chooseMainManuItem(){

        val textInputField: Matcher<View> by lazy { withId(R.id.text) }
        withId(R.id.tv_name)
    }
}