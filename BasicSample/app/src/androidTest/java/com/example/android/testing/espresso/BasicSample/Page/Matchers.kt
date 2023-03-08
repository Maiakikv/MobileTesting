package com.example.android.testing.espresso.BasicSample.Page
import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import com.example.android.testing.espresso.BasicSample.R


object Matchers {
    val textEditor: Matcher<View> by lazy { withId(R.id.editTextUserInput) }
    val changeTextButton: Matcher<View> by lazy { withId(R.id.changeTextBt) }
    val textTobeCanged: Matcher<View> by lazy { withId(R.id.textToBeChanged) }
    val openActivityButton: Matcher<View> by lazy { withId(R.id.activityChangeTextBtn) }
}


