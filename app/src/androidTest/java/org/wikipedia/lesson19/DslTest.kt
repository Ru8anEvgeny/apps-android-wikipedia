package org.wikipedia.lesson19

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen

class DslTest : BaseTest() {

    @Test
    fun example() {
        run() {
            val steps = StepDefinitions(this)
            val action = Actions(steps)
            val verify = Verify(steps)
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock("Customize") {
                verify.isDisplayed(this)
            }
        }
    }

}