package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import com.atiurin.sampleapp.framework.*
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.typeText
import com.atiurin.ultron.page.Page
import com.atiurin.ultron.recyclerview.UltronRecyclerViewItem
import com.atiurin.ultron.recyclerview.withRecyclerView
import com.atiurin.ultron.core.espresso.UltronEspresso
import com.atiurin.ultron.extensions.isDisplayed
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Assert

object ChatPage : Page<ChatPage>() {
    fun assertPageDisplayed() = apply {
        step("Assert friends list page displayed") {
            messagesList.isDisplayed()
        }
    }

    val messagesList = withRecyclerView(R.id.messages_list)
    val clearHistoryBtn = withText("Clear history")
    val inputMessageText = withId(R.id.message_input_text)
    val sendMessageBtn = withId(R.id.send_button)

    fun getMessageListItem(text: String): ChatRecyclerItem {
        return messagesList.getItem(hasDescendant(
                allOf(
                    withId(R.id.message_text),
                    withText(text)
                )
            )
        )
    }

    private fun getListItemAtPosition(position: Int): ChatRecyclerItem {
        return messagesList.getItem(position)
    }

    fun getTitle(title: String): Matcher<View> {
        return allOf(withId(R.id.toolbar_title), withText(title))
    }

    class ChatRecyclerItem : UltronRecyclerViewItem(){
        val text = getChild(withId(R.id.message_text))
    }

    fun sendMessage(text: String) = apply {
        step("Send message with text '$text") {
            inputMessageText.typeText(text)
            sendMessageBtn.click()
            this.getMessageListItem(text).text
                .isDisplayed()
                .hasText(text)
        }
    }

    fun assertMessageTextAtPosition(position: Int, text: String) = apply {
        this.getListItemAtPosition(position).text.isDisplayed().hasText(text)
    }

    fun clearHistory() = apply {
        step("Clear chat history") {
//            UltronInteraction.openActionBarOverflowOrOptionsMenu()
            UltronEspresso.openContextualActionModeOverflowMenu()
            clearHistoryBtn.click()
            Assert.assertEquals(0, messagesList.getSize())
        }
    }

    fun assertMessageDisplayed(text: String) {
        getMessageListItem(text).text
            .isDisplayed()
            .hasText(text)
    }
}