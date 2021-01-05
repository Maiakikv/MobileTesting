package com.atiurin.sampleapp.tests.espresso_web

import androidx.test.espresso.web.assertion.WebViewAssertions
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.matcher.DomMatchers
import androidx.test.espresso.web.webdriver.DriverAtoms.getText
import com.atiurin.sampleapp.framework.Log
import com.atiurin.sampleapp.framework.utils.AssertUtils
import com.atiurin.sampleapp.pages.WebViewPage
import com.atiurin.ultron.core.espressoweb.webelement.WebDocument
import com.atiurin.ultron.core.espressoweb.webelement.WebElement
import com.atiurin.ultron.core.espressoweb.webelement.WebElement.Companion.className
import com.atiurin.ultron.core.espressoweb.webelement.WebElement.Companion.id
import org.hamcrest.Matchers.`is`
import org.junit.Assert
import org.junit.Test

class WebElementTest : BaseWebViewTest() {
    @Test
    fun webClick_onExistElement() {
        page.buttonSetTitle2.webClick()
        page.title.hasText(WebViewPage.BUTTON2_TITLE)
    }

    @Test
    fun webClick_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").webClick(timeoutMs = 100) }
    }

    @Test
    fun webClick_isSuccessTrueValue() {
        val success = page.buttonSetTitle2.isSuccess { webClick() }
        Assert.assertTrue(success)
    }

    @Test
    fun webClick_isSuccessFalseValue() {
        val success = id("notExistId").isSuccess { webClick(100) }
        Assert.assertFalse(success)
    }

    @Test
    fun exists_onExistElement() {
        page.buttonUpdTitle.exists()
    }

    @Test
    fun exists_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").exists(timeoutMs = 100) }
    }

    @Test
    fun exists_isSuccessTrueValue() {
        val success = page.buttonSetTitle2.isSuccess { exists() }
        Assert.assertTrue(success)
    }

    @Test
    fun exists_isSuccessFalseValue() {
        val success = id("notExistId").isSuccess { exists(100) }
        Assert.assertFalse(success)
    }

    @Test
    fun clearElement_onExistedEditableElement() {
        page.textInput.webKeys("initial text")
            .clearElement()
            .hasText("")
    }

    @Test
    fun clearElement_onExistedNotEditableElement() {
        AssertUtils.assertException { page.buttonUpdTitle.clearElement(100) }
    }

    @Test
    fun clearElement_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").clearElement(100) }
    }

    @Test
    fun getText_onExistedTextContainerElement() {
        val text = "some text 2"
        page.textInput.replaceText(text)
        page.buttonUpdTitle.webClick()
        val receivedText = page.title.getText()
        Assert.assertEquals(text, receivedText)
    }

    @Test
    fun getText_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").getText(100) }
    }

    @Test
    fun webKeys_onExistedTextContainerElement() {
        val text = "some text 3"
        page.textInput.clearElement().webKeys(text)
        page.buttonUpdTitle.webClick()
        page.title.hasText(text)
    }

    @Test
    fun webKeys_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").webKeys("asd", 100) }
    }

    @Test
    fun replaceText_and_hasText_onExistedElement() {
        val text = "some text 3"
        page.textInput.replaceText(text)
        page.buttonUpdTitle.webClick()
        page.title.hasText(text)
    }

    @Test
    fun replaceText_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").replaceText("asd", 100) }
    }

    @Test
    fun hasText_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").hasText("asd", 100) }
    }

    @Test
    fun containsText_onExistedElement() {
        val text = "some text 3"
        page.textInput.replaceText(text + "additional")
        page.buttonUpdTitle.webClick()
        page.title.containsText(text)
    }

    @Test
    fun containsText_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").containsText("asd", 100) }
    }

    @Test
    fun hasAttribute_withMatcher_onExistedElement() {
        page.appleLink.hasAttribute("href", `is`(WebViewPage.APPLE_LINK_HREF))
    }

    @Test
    fun hasAttribute_withString_onExistedElement() {
        page.appleLink.hasAttribute("href", WebViewPage.APPLE_LINK_HREF)
    }

    @Test
    fun hasAttribute_invalidMatcher_onExistedElement() {
        AssertUtils.assertException {
            page.appleLink.hasAttribute("href", `is`("SomeInvalidValue"), timeoutMs = 100)
        }
    }

    @Test
    fun hasAttribute_onNotExistedElement() {
        AssertUtils.assertException { id("notExistId").hasAttribute("asd", `is`("asdasd"), 100) }
    }

    @Test
    fun assertThat_onExistedElement() {
        page.appleLink.assertThat(webMatches(getText(), `is`("Apple")))
    }

    @Test
    fun assertThat_onNotExistedElement() {
        AssertUtils.assertException {
            id("notExistId").assertThat(
                webMatches(
                    getText(),
                    `is`("Apple")
                )
            )
        }
    }

    @Test
    fun withContextual_hasText() {
        id("teacher")
            .containsText("Teachers")
            .withContextual(className("person_name"))
            .hasText("Socrates")
    }

    @Test
    fun withContextual_containsText() {
        id("student")
            .withContextual(className("person_name"))
            .hasText("Plato")
    }

    @Test
    fun scrollToWebElement() {
        id("list_element_12")
            .webScrollIntoView()
            .hasText("list_element_12")
            .webClick()
        Thread.sleep(3000)
    }

    @Test
    fun webScrollIntoViewBoolean() {
        val result = id("list_element_12")
            .webScrollIntoViewBoolean ()
        Assert.assertTrue(result)
    }
}