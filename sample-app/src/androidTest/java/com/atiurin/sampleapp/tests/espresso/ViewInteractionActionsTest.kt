package com.atiurin.sampleapp.tests.espresso

import android.os.SystemClock
import android.view.KeyEvent
import androidx.test.espresso.action.EspressoKey
import androidx.test.espresso.action.ViewActions.click
import com.atiurin.sampleapp.R
import com.atiurin.sampleapp.framework.utils.AssertUtils
import com.atiurin.sampleapp.framework.utils.TestDataUtils.getResourceString
import com.atiurin.sampleapp.pages.UiElementsPage
import com.atiurin.sampleapp.tests.UiElementsTest
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.core.espresso.UltronEspresso
import com.atiurin.ultron.extensions.*
import com.atiurin.ultron.utils.getTargetString
import org.junit.Assert
import org.junit.Test

class ViewInteractionActionsTest : UiElementsTest() {
    val page = UiElementsPage

    @Test
    fun testNotExistedElement(){
        val startTime = SystemClock.elapsedRealtime()
        val result = page.notExistElement.isSuccess { isDisplayed() }
        val endTime = SystemClock.elapsedRealtime()
        Assert.assertTrue(endTime - startTime >= UltronConfig.Espresso.ASSERTION_TIMEOUT)
        Assert.assertFalse(result)
    }

    @Test
    fun click_onClickable() {
        page.button.click()
        page.eventStatus.textContains(getTargetString(R.string.button_event_click))
    }

    @Test
    fun click_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).click() }
    }

    @Test
    fun longClick_onLongClickable() {
        page.button.longClick()
        page.eventStatus.textContains(getTargetString(R.string.button_event_long_click))
    }

    @Test
    fun longClick_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).longClick() }
    }
    @Test
    fun doubleClick_onClickable() {
        page.button.doubleClick()
        page.button.withTimeout(1000).isDisplayed()
        var success = false
        with(page.eventStatus){
            textContains(getResourceString(R.string.button_event_click))
            success = isSuccess { withTimeout(3000).textContains("1") } ||  isSuccess { withTimeout(2000).textContains("2") }
        }
        Assert.assertTrue(success)
    }
    @Test
    fun doubleClick_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).doubleClick() }
    }

    @Test
    fun typeText_onEditable() {
        val text1 = "begin"
        val text2 = "simple text"
        page.editTextContentDesc.replaceText(text1).typeText(text2).hasText("$text1$text2")
    }

    @Test
    fun typeText_onNotEditable() {
        AssertUtils.assertException { page.eventStatus.withTimeout(100).typeText("simple text") }
    }
    @Test
    fun typeText_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).typeText("asd") }
    }

    @Test
    fun replaceText_onEditable() {
        val text = "simple text"
        page.editTextContentDesc.replaceText(text).hasText(text)
    }
    @Test
    fun replaceText_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).replaceText("asd") }
    }

    @Test
    fun clearText_onEditable() {
        page.editTextContentDesc.clearText().hasText("")
    }
    @Test
    fun clearText_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).clearText() }
    }

    @Test
    fun pressKey_onEditable() {
        val text = "simple text"
        val expectedText = text.substring(0, text.length - 1)
        page.editTextContentDesc
            .replaceText(text)
            .click()
            .pressKey(KeyEvent.KEYCODE_DEL)
            .hasText(expectedText)
    }

    @Test
    fun pressKey_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).pressKey(KeyEvent.KEYCODE_DEL) }
    }

    @Test
    fun pressEspressoKey_onEditable() {
        val text = "simple text"
        val expectedText = text.substring(0, text.length - 1)
        page.editTextContentDesc
            .replaceText(text)
            .click()
            .pressKey(EspressoKey.Builder().withKeyCode(KeyEvent.KEYCODE_DEL).build())
            .hasText(expectedText)
    }

    @Test
    fun pressEspressoKey_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).pressKey(EspressoKey.Builder().withKeyCode(KeyEvent.KEYCODE_DEL).build()) }
    }

    @Test
    fun closeSoftKeyboard_whenItOpened(){
        page.editTextContentDesc.click()
        SystemClock.sleep(500)
        page.editTextContentDesc.closeSoftKeyboard()
    }

    @Test
    fun preformCustomClick_onClickable(){
        page.button.perform(click())
        page.eventStatus.textContains(getResourceString(R.string.button_event_click))
    }

    @Test
    fun performCustom_notExisted() {
        AssertUtils.assertException { page.notExistElement.withTimeout(100).perform(click()) }
    }

    @Test
    fun closeSoftKeyboardTest(){
        page.editTextContentDesc.click()
        UltronEspresso.closeSoftKeyboard()
        page.emptyNotClickableImageView.isDisplayed()
    }
}