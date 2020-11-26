package com.atiurin.ultron.core.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.atiurin.ultron.core.common.Operation
import com.atiurin.ultron.core.common.OperationIterationResult
import com.atiurin.ultron.core.common.OperationType
import com.atiurin.ultron.core.uiautomator.UiAutomatorConfig

class UiAutomatorUiSelectorOperation(
        val block: UiObject.() -> Boolean,
        private val uiSelector: UiSelector,
        override val name: String,
        override val description: String,
        override val type: OperationType,
        override val timeoutMs: Long) : Operation {
    override fun execute(): OperationIterationResult {
        var success = true
        var exception: Throwable? = null
        try {
            success = UiAutomatorConfig.uiDevice.findObject(uiSelector).block()
        } catch (error: Throwable) {
            success = false
            exception = error
        }
        return OperationIterationResult(success, exception)
    }
}