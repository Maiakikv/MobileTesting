package com.atiurin.ultron.core.uiautomator.uiobject2

import com.atiurin.ultron.core.common.Operation
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.core.uiautomator.UiAutomatorOperation
import com.atiurin.ultron.core.uiautomator.UiAutomatorOperationExecutor

class UiAutomatorBySelectorAssertionExecutor(
        assertion: UiAutomatorBySelectorAssertion
) : UiAutomatorOperationExecutor<UiAutomatorOperation>(assertion) {
    override fun getAllowedExceptions(operation: Operation): List<Class<out Throwable>> {
        return UltronConfig.UiAutomator.UiObject2Config.allowedExceptions
    }
}