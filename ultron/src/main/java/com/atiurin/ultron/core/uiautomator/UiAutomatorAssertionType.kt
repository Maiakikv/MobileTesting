package com.atiurin.ultron.core.uiautomator

import com.atiurin.ultron.core.common.OperationType

enum class UiAutomatorAssertionType :
    OperationType {
    IS_DISPLAYED, IS_NOT_DISPLAYED, IS_COMPLETELY_DISPLAYED, IS_DISPLAYING_AT_LEAST,
    IS_ENABLED, IS_NOT_ENABLED,
    IS_CLICKABLE, IS_NOT_CLICKABLE,
    IS_LONG_CLICKABLE, IS_NOT_LONG_CLICKABLE,
    IS_CHECKED, IS_NOT_CHECKED,
    IS_CHECKABLE, IS_NOT_CHECKABLE,
    IS_FOCUSABLE, IS_NOT_FOCUSABLE, IS_FOCUSED, IS_NOT_FOCUSED,
    IS_SELECTED, IS_NOT_SELECTED,
    IS_SCROLLABLE, IS_NOT_SCROLLABLE,
    HAS_TEXT, TEXT_CONTAINS, TEST_IS_NULL_OR_EMPTY, TEST_IS_NOT_NULL_OR_EMPTY,
    HAS_CONTENT_DESCRIPTION, CONTENT_DESCRIPTION_CONTAINS_TEXT, CONTENT_DESCRIPTION_IS_NULL_OR_EMPTY, CONTENT_DESCRIPTION_IS_NOT_NULL_OR_EMPTY,
    ASSERT_THAT, EXISTS, NOT_EXISTS
}