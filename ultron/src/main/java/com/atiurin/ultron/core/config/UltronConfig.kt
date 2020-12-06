package com.atiurin.ultron.core.config

import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.PerformException
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.Configurator
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObjectNotFoundException
import com.atiurin.ultron.core.common.DefaultOperationResultAnalyzer
import com.atiurin.ultron.core.common.Operation
import com.atiurin.ultron.core.common.OperationResult
import com.atiurin.ultron.core.common.OperationResultAnalyzer
import com.atiurin.ultron.core.espresso.EspressoOperationResult
import com.atiurin.ultron.core.espresso.action.DataInteractionEspressoAction
import com.atiurin.ultron.core.espresso.action.ViewInteractionEspressoAction
import com.atiurin.ultron.core.espresso.assertion.DataInteractionEspressoAssertion
import com.atiurin.ultron.core.espresso.assertion.ViewInteractionEspressoAssertion
import com.atiurin.ultron.core.uiautomator.UiAutomatorOperationResult
import com.atiurin.ultron.core.uiautomator.byselector.UiAutomatorBySelectorAction
import com.atiurin.ultron.core.uiautomator.byselector.UiAutomatorBySelectorAssertion
import com.atiurin.ultron.core.uiautomator.uiselector.UiAutomatorUiSelectorOperation
import junit.framework.AssertionFailedError

object UltronConfig {
    var LOGCAT_TAG = "Ultron"

    class Espresso {
        companion object {
            var ESPRESSO_OPERATION_POLLING_TIMEOUT = 50L //ms
            var ACTION_TIMEOUT = 5_000L
            var ASSERTION_TIMEOUT = 5_000L

            var resultAnalyzer : OperationResultAnalyzer = DefaultOperationResultAnalyzer()

            inline fun setResultAnalyzer(crossinline block: (OperationResult<Operation>) -> Boolean) {
                resultAnalyzer = object : OperationResultAnalyzer {
                    override fun <Op : Operation, OpRes : OperationResult<Op>> analyze(operationResult: OpRes): Boolean {
                        return block(operationResult as OperationResult<Operation>)
                    }
                }
            }
        }

        class ViewActionConfig {
            companion object {
                var allowedExceptions = mutableListOf<Class<out Throwable>>(
                    PerformException::class.java,
                    NoMatchingViewException::class.java
                )

                val dataInteractionResultHandler: (EspressoOperationResult<DataInteractionEspressoAction>) -> Unit =
                    {
                        resultAnalyzer.analyze(it)
                    }
                val viewInteractionResultHandler: (EspressoOperationResult<ViewInteractionEspressoAction>) -> Unit =
                    {
                        resultAnalyzer.analyze(it)
                    }
            }
        }

        class ViewAssertionConfig {
            companion object {
                var allowedExceptions = mutableListOf<Class<out Throwable>>(
                    PerformException::class.java,
                    NoMatchingViewException::class.java,
                    AssertionFailedError::class.java
                )
                val dataInteractionResultHandler: (EspressoOperationResult<DataInteractionEspressoAssertion>) -> Unit =
                    {
                        resultAnalyzer.analyze(it)
                    }
                val viewInteractionResultHandler: (EspressoOperationResult<ViewInteractionEspressoAssertion>) -> Unit =
                    {
                        resultAnalyzer.analyze(it)
                    }
            }
        }
    }

    class UiAutomator {
        companion object {
            var UIAUTOMATOR_OPERATION_POLLING_TIMEOUT = 50L //ms
            var ACTION_TIMEOUT = 5_000L
            var ASSERTION_TIMEOUT = 5_000L

            var resultAnalyzer : OperationResultAnalyzer = DefaultOperationResultAnalyzer()

            inline fun setResultAnalyzer(crossinline block: (OperationResult<Operation>) -> Boolean) {
                resultAnalyzer = object : OperationResultAnalyzer {
                    override fun <Op : Operation, OpRes : OperationResult<Op>> analyze(operationResult: OpRes): Boolean {
                        return block(operationResult as OperationResult<Operation>)
                    }
                }
            }
            val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

            fun setIdlingTimeout(timeoutMs: Long){
                Configurator.getInstance().apply {
                    waitForIdleTimeout = timeoutMs
                    waitForSelectorTimeout = timeoutMs
                }
            }
        }
        //UiSelector
        class UiObjectConfig {
            companion object {
                var allowedExceptions = mutableListOf<Class<out Throwable>>(
                    UiObjectNotFoundException::class.java
                )
                val resultHandler: (UiAutomatorOperationResult<UiAutomatorUiSelectorOperation>) -> Unit = {
                    resultAnalyzer.analyze(it)
                }
            }
        }
        //BySelector
        class UiObject2Config {
            companion object {
                var allowedExceptions = mutableListOf<Class<out Throwable>>(
                    UiObjectNotFoundException::class.java
                )
                val bySelectorActionResultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = {
                    resultAnalyzer.analyze(it)
                }
                val bySelectorAssertionResultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAssertion>) -> Unit = {
                    resultAnalyzer.analyze(it)
                }
            }
        }
    }
}