package org.wikipedia.lesson18.homework

import org.junit.Test
import org.wikipedia.lesson18.getName

class NamedTests : BaseTest() {

    @Test
    fun simpleTest() {
        run {
            OnboardingScreen {
                page(2) {
                    step("Проверяет отображение элемента '${image.getName()}'") {
                        image.isDisplayed()
                    }
                }
                step("Нажимает на '${skipButton.getName()}'") {
                    skipButton.click()
                }
            }
        }
    }
}