package com.atiurin.ultron.core.uiautomator

import com.atiurin.ultron.core.common.OperationType

enum class UiAutomatorActionType :
        OperationType {
    CLICK, LONG_CLICK, DOUBLE_CLICK,
    DRAG, FLING, PINCH_CLOSE, PINCH_OPEN,
    ADD_TEXT, REPLACE_TEXT, CLEAR_TEXT, PRESS_KEY, CLOSE_SOFT_KEYBOARD, GET_TEXT, LEGACY_SET_TEXT,
    GET_APPLICATION_PACKAGE, GET_VISIBLE_BOUNDS, GET_VISIBLE_CENTER, GET_CLASS_NAME, GET_CONTENT_DESCRIPTION, GET_RESOURCE_NAME,
    SWIPE, SWIPE_LEFT, SWIPE_RIGHT, SWIPE_UP, SWIPE_DOWN, SCROLL, CUSTOM
}