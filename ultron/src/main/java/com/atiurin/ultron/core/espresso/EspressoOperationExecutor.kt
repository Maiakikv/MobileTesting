package com.atiurin.ultron.core.espresso

import android.os.SystemClock
import com.atiurin.ultron.core.common.Operation
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.core.config.UltronConfig.Espresso
import com.atiurin.ultron.core.config.UltronConfig.Espresso.Companion.ESPRESSO_OPERATION_POLLING_TIMEOUT
import com.atiurin.ultron.core.espresso.action.EspressoAction
import com.atiurin.ultron.extensions.isAssignedFrom

abstract class EspressoOperationExecutor(
    private val operation: Operation
) : EspressoExecutor {
    override fun execute(): EspressoOperationResult {
        var success = true
        var description = ""
        val exceptions: MutableList<Throwable> = mutableListOf()
        val endTime = SystemClock.elapsedRealtime() + operation.timeoutMs
        try {
            do {
                val result = operation.execute()
                success = result.success
                if (!success) {
                    val error =
                        result.exception ?: UnknownError("Create an issue to espresso-page-object")
                    if (error::class.java.isAssignedFrom(getAllowedExceptions(operation))) {
                        if (exceptions.find { it.javaClass.simpleName == error.javaClass.simpleName } == null) {
                            exceptions.add(error)
                        }
                    } else {
                        description = "Not allowed exception occurs - ${error.javaClass.simpleName}, message - ${error.message}, cause - ${error.cause}"
                        exceptions.add(error)
                        throw error
                    }
                }
                if (success) SystemClock.sleep(ESPRESSO_OPERATION_POLLING_TIMEOUT)
            } while (SystemClock.elapsedRealtime() < endTime && !success)
        } catch (th: Throwable) {
            success = false // just make sure we will have correct action status
        }
        if (!success && exceptions.isNotEmpty()) {
            description +=
                """
                |Espresso operation '${operation.name}' with type ${operation.type} during ${operation.timeoutMs} ms was failed. 
                |Operation description: ${operation.description}
                |Errors were caught: 
                |${exceptions.map { "- '${it.javaClass.simpleName}', cause: '${it.cause}'\n" }}
                |Last error message: '${exceptions.last().message}', cause: '${exceptions.last().cause}'
                """.trimMargin()

        }
        return EspressoOperationResult(
            operation = operation,
            success = success,
            exception = exceptions.lastOrNull()
        ).apply {
            this.resultDescription = EspressoOperationResultDescription(
                this,
                description
            )
        }
    }

    override fun getOperation(): Operation = operation
}