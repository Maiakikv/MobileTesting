package com.atiurin.ultron.extensions

import android.graphics.Point
import android.graphics.Rect
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.Direction
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.core.config.UltronConfig.UiAutomator.Companion.uiDevice
import com.atiurin.ultron.core.uiautomator.UiAutomatorOperationResult
import com.atiurin.ultron.core.uiautomator.uiobject2.*

fun BySelector.isSuccess(
    action: BySelector.() -> Unit
): Boolean {
    return this.methodToBoolean(action)
}

/** Clicks on this object. */
fun BySelector.click(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.click({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Performs a click on this object that lasts for {@code duration} milliseconds. */
fun BySelector.click(
    duration: Long,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.click({ uiDevice.findObject(this) }, this.toString(), duration, timeoutMs, resultHandler)
}

/** Performs a long click on this object. */
fun BySelector.longClick(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.longClick({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Clears the text content if this object is an editable field. */
fun BySelector.clear(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.clear({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/**
 * @return view text
 */
fun BySelector.getText(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): String {
    return UiObject2Operation.getText({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Returns the package name of the app that this object belongs to. */
fun BySelector.getApplicationPackage(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): String {
    return UiObject2Operation.getApplicationPackage({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Returns the visible bounds of this object in screen coordinates. */
fun BySelector.getVisibleBounds(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): Rect {
    return UiObject2Operation.getVisibleBounds({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Returns a point in the center of the visible bounds of this object. */
fun BySelector.getVisibleCenter(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): Point {
    return UiObject2Operation.getVisibleCenter({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Returns the fully qualified resource name for this object's id.  */
fun BySelector.getResourceName(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): String {
    return UiObject2Operation.getResourceName({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/**
 * Returns the class name of the underlying [android.view.View] represented by this object.
 */
fun BySelector.getClassName(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): String {
    return UiObject2Operation.getClassName({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Returns the content description for this object. */
fun BySelector.getContentDescription(
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) : String {
    return UiObject2Operation.getContentDescription({ uiDevice.findObject(this) }, this.toString(), timeoutMs, resultHandler)
}

/** Add the text content if this object is an editable field. */
fun BySelector.addText(
    text: String,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    return UiObject2Operation.addText({ uiDevice.findObject(this) }, this.toString(), text, timeoutMs, resultHandler)
}

/**
 * Set the text content by sending individual key codes.
 * @hide
 */
fun BySelector.legacySetText(
    text: String,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    return UiObject2Operation.legacySetText({ uiDevice.findObject(this) }, this.toString(), text, timeoutMs, resultHandler)
}

/** Sets the text content if this object is an editable field. */
fun BySelector.replaceText(
    text: String,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    return UiObject2Operation.replaceText({ uiDevice.findObject(this) }, this.toString(), text, timeoutMs, resultHandler)
}

fun BySelector.drag(
    dest: Point,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.drag({ uiDevice.findObject(this) }, this.toString(), dest, timeoutMs, resultHandler)
}

fun BySelector.drag(
    dest: Point,
    speed: Int,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.drag({ uiDevice.findObject(this) }, this.toString(), dest, speed, timeoutMs, resultHandler)
}

/**
 * Performs a pinch close gesture on this object.
 *
 * @param percent The size of the pinch as a percentage of this object's size.
 */
fun BySelector.pinchClose(
    percent: Float,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.pinchClose({ uiDevice.findObject(this) }, this.toString(), percent, timeoutMs, resultHandler)
}

/**
 * Performs a pinch close gesture on this object.
 *
 * @param percent The size of the pinch as a percentage of this object's size.
 * @param speed The speed at which to perform this gesture in pixels per second.
 */
fun BySelector.pinchClose(
    percent: Float,
    speed: Int,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.pinchClose({ uiDevice.findObject(this) }, this.toString(), percent, speed, timeoutMs, resultHandler)
}

/**
 * Performs a pinch open gesture on this object.
 *
 * @param percent The size of the pinch as a percentage of this object's size.
 */
fun BySelector.pinchOpen(
    percent: Float,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.pinchOpen({ uiDevice.findObject(this) }, this.toString(), percent, timeoutMs, resultHandler)
}

/**
 * Performs a pinch open gesture on this object.
 *
 * @param percent The size of the pinch as a percentage of this object's size.
 * @param speed The speed at which to perform this gesture in pixels per second.
 */
fun BySelector.pinchOpen(
    percent: Float,
    speed: Int,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.pinchOpen({ uiDevice.findObject(this) }, this.toString(), percent, speed, timeoutMs, resultHandler)
}

/**
 * Performs a swipe gesture on this object.
 *
 * @param direction The direction in which to swipe.
 * @param percent The length of the swipe as a percentage of this object's size.
 */
fun BySelector.swipe(
    direction: Direction,
    percent: Float,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.swipe({ uiDevice.findObject(this) }, this.toString(), direction, percent, timeoutMs, resultHandler)
}

/**
 * Performs a swipe gesture on this object.
 *
 * @param direction The direction in which to swipe.
 * @param percent The length of the swipe as a percentage of this object's size.
 * @param speed The speed at which to perform this gesture in pixels per second.
 */
fun BySelector.swipe(
    direction: Direction,
    percent: Float,
    speed: Int,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
) {
    UiObject2Operation.swipe({ uiDevice.findObject(this) }, this.toString(), direction, percent, speed, timeoutMs, resultHandler)
}

/**
 * Performs a scroll gesture on this object.
 *
 * @param direction The direction in which to scroll.
 * @param percent The distance to scroll as a percentage of this object's visible size.
 * @return Whether the object can still scroll in the given direction.
 */
fun BySelector.scroll(
    direction: Direction,
    percent: Float,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): Boolean {
    return UiObject2Operation.scroll({ uiDevice.findObject(this) }, this.toString(), direction, percent, timeoutMs, resultHandler)
}

/**
 * Performs a scroll gesture on this object.
 *
 * @param direction The direction in which to scroll.
 * @param percent The distance to scroll as a percentage of this object's visible size.
 * @param speed The speed at which to perform this gesture in pixels per second.
 * @return Whether the object can still scroll in the given direction.
 */
fun BySelector.scroll(
    direction: Direction,
    percent: Float,
    speed: Int,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): Boolean {
    return UiObject2Operation.scroll({ uiDevice.findObject(this) }, this.toString(), direction, percent, speed, timeoutMs, resultHandler)
}

/**
 * Performs a fling gesture on this object.
 *
 * @param direction The direction in which to fling.
 * @return Whether the object can still scroll in the given direction.
 */
fun BySelector.fling(
    direction: Direction,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): Boolean {
    return UiObject2Operation.fling({ uiDevice.findObject(this) }, this.toString(), direction, timeoutMs, resultHandler)
}

/**
 * Performs a fling gesture on this object.
 *
 * @param direction The direction in which to fling.
 * @param speed The speed at which to perform this gesture in pixels per second.
 * @return Whether the object can still scroll in the given direction.
 */
fun BySelector.fling(
    direction: Direction,
    speed: Int,
    timeoutMs: Long = UltronConfig.UiAutomator.ACTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAction>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorActionResultHandler
): Boolean {
    return UiObject2Operation.fling({ uiDevice.findObject(this) }, this.toString(), direction, speed, timeoutMs, resultHandler)
}


//asserts
fun BySelector.hasText(
    text: String,
    timeoutMs: Long = UltronConfig.UiAutomator.ASSERTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAssertion>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorAssertionResultHandler
) {
    UiObject2Operation.hasText({ uiDevice.findObject(this) }, this.toString(), text, timeoutMs, resultHandler)
}

fun BySelector.containsText(
    text: String,
    timeoutMs: Long = UltronConfig.UiAutomator.ASSERTION_TIMEOUT,
    resultHandler: (UiAutomatorOperationResult<UiAutomatorBySelectorAssertion>) -> Unit = UltronConfig.UiAutomator.UiObject2Config.bySelectorAssertionResultHandler
) {
    UiObject2Operation.textContains({ uiDevice.findObject(this) }, this.toString(), text, timeoutMs, resultHandler)
}