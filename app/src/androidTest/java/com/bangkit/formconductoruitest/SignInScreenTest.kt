package com.bangkit.formconductoruitest

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

internal class SignInScreenTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_enableButton_when_formValid() {
        rule.setContent { SignInScreen() }

        rule.onNodeWithTag("SignInButton").assertIsNotEnabled()

        rule.onNodeWithTag("EmailField").assertIsNotFocused()
        rule.onNodeWithTag("EmailField").performClick()
        rule.onNodeWithTag("EmailField").performTextInput("test@gmail.com")
        rule.onNodeWithTag("EmailField").performImeAction()

        rule.onNodeWithTag("SignInButton").assertIsNotEnabled()

        rule.onNodeWithTag("PasswordField").assertIsFocused()
        rule.onNodeWithTag("PasswordField").performTextInput("password")
        rule.onNodeWithTag("PasswordField").performImeAction()

        rule.onNodeWithTag("SignInButton").assertIsEnabled()
    }
}