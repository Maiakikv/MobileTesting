package com.atiurin.sampleapp.steps

import com.atiurin.sampleapp.pages.ChatPageMatchersMaia
import com.atiurin.sampleapp.pages.FriendsPageMatchersMaia
import com.atiurin.ultron.extensions.tap
import com.atiurin.ultron.extensions.typeText

object Actions {
    fun openChatStep(friendName: String) {
        when (friendName) {
            "Chandler" -> FriendsPageMatchersMaia.Chandler.tap()
            "Ross" -> FriendsPageMatchersMaia.Ross.tap()
            "Gunther" -> FriendsPageMatchersMaia.Gunther.tap()
            "Janice" -> FriendsPageMatchersMaia.Janice.tap()
            "Monica" -> FriendsPageMatchersMaia.Monica.tap()
            "Phoebe" -> FriendsPageMatchersMaia.Phoebe.tap()
            "Rachel" -> FriendsPageMatchersMaia.Rachel.tap()
        }
    }
    fun enterAndSendTextStep(text: String) {
        ChatPageMatchersMaia.inputMessageText.typeText(text)
        ChatPageMatchersMaia.sendMessageBtn.tap()
    }
}
