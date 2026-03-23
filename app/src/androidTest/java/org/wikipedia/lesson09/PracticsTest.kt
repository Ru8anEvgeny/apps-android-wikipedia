package org.wikipedia.lesson09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

class PracticsTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun tests() {
        run("") {
            OnboardingScreen {
                step("Нажимает кнопку скип") {
                    skipButton.click()
                }
            }


        }
    }
}