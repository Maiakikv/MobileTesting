package com.atiurin.sampleapp.tests.espresso

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.atiurin.sampleapp.R
import com.atiurin.sampleapp.activity.CustomClicksActivity
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.data.repositories.ContactRepositoty
import com.atiurin.sampleapp.framework.Log
import com.atiurin.sampleapp.helper.tap
import com.atiurin.sampleapp.helper.wait
import com.atiurin.sampleapp.pages.MainManuPage
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.sampleapp.tests.BaseTest
import com.atiurin.sampleapp.tests.UiElementsTest
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.isDisplayed
import com.atiurin.ultron.extensions.tap
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CustomClickTests (){

    @get:Rule val activityTestRule = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun validateCheckedPoints(){
        with(UIElementPage){
            nameChandler.tap()
            nameChandler.tap()


//            withId(R.id.button1).tap()
//            withId(R.id.button1).tap()
//            withId(R.id.button1).tap()


        }

    }

    @Test
    fun radioBtnTest(){
        with(UIElementPage){
 //           radioBtnInvisible.isDisplayed()
//            radioBtnInvisible.tap()
//            radioBtnVisible.tap()

        }



    }

}