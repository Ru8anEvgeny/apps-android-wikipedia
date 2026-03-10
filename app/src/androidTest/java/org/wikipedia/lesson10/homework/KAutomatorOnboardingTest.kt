package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson10.OnboardingUiScreen
import org.wikipedia.main.MainActivity

class KAutomatorOnboardingTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkTest() {
        run {
            OnboardingUiScreen {
                step("Проверка заголовка/подзаголовка на первой странице"){
                    title.containsText("The Free Encyclopedia")
                    subTitle.containsText("found the following")
                }
                step("Тап на continue"){
                    continueButton.click()
                }
                step("Проверка заголовка/подзаголовка на второй странице"){
                    title.containsText("New ways to explore")
                    subTitle.containsText("Dive down the Wikipedia")
                }
                step("Тап на continue"){
                    continueButton.click()
                }
                step("Проверка заголовка/подзаголовка на третьей странице"){
                    title.containsText("Reading lists with sync")
                    subTitle.containsText("You can make reading list")
                }
                step("Тап на continue"){
                    continueButton.click()
                }
                step("Проверка заголовка/подзаголовка на четвертой странице"){
                    title.containsText("Data & Privacy")
                    subTitle.containsText("We believe that you")
                }

            }
        }
    }
}