package com.example.android.testing.espresso.BasicSample.Steps

import com.example.android.testing.espresso.BasicSample.Page.Matchers
import com.example.android.testing.espresso.BasicSample.tap
import com.example.android.testing.espresso.BasicSample.typeText

object Actions {
    fun changeActionStep(text: String) {
        Matchers.textEditor.typeText(text)

    }

    fun openActivityStep(text: String) {
        Matchers.textEditor.typeText(text)


    }
}