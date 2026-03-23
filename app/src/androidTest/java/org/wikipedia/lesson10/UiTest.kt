package org.wikipedia.lesson10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson10.homework.KAutomatorOnboardingScreen
import org.wikipedia.main.MainActivity

class UiTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSkip() {
        run("Проверка отображения кнопки скип") {
            OnboardingUiScreen.skipButton.isDisplayed()
            OnboardingScreen.skipButton.isDisplayed()

        }
    }


}