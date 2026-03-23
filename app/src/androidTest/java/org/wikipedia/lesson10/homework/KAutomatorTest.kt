package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson10.UiTest
import org.wikipedia.main.MainActivity

class KAutomatorTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun kAutomatorTest() {
        run("Тест автоматора") {
            KAutomatorOnboardingScreen {
                step("Отображаются основные элементы экрана") {
                    skipButton.isDisplayed()
                    continueButton.isDisplayed()
                    addLanguagesButton.isDisplayed()
                    image.isDisplayed()
                    secondaryText.containsText("following on your device")
                    primaryText.containsText("over 300 languages")
                }

                step("Нажимает на кнопу континье") {
                    continueButton.click()
                }

                step("Проверяет что текст сменился") {
                    primaryText.containsText("New ways to explore")
                    secondaryText.containsText("Customize the feed")
                    skipButton.isDisplayed()
                    image.isDisplayed()
                }

                step("Нажимает на кнопку континье") {
                    continueButton.click()
                }

                step("Проверяет что текст сменился") {
                    continueButton.isDisplayed()
                    primaryText.containsText("Reading")
                    secondaryText.containsText("You can make")
                    continueButton.click()
                }

                step("нажимает на кнопку континье") {
                    continueButton.isDisplayed()
                    primaryText.containsText("Data & Privacy")
                    secondaryText.containsText("We believe")
                }

                OnboardingScreen.skipButton.isNotDisplayed()

            }
        }
    }
}