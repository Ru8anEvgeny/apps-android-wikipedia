package org.wikipedia.lesson22.homework

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.junit.Test
import org.wikipedia.Constants
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.action
import org.wikipedia.lesson19.verify
import org.wikipedia.theme.ThemeChooserDialog

class ThemeChooserTest : BaseTest() {

    @Test
    fun checkThemeChooserWidgets() {
        run {
            openThemeChooser()
            verify {
                ThemeChooserScreen.fontWidget {
                    isDisplayed(this)
                    isDisplayed(textSizePercent)
                    isDisplayed(decreaseButton)
                    isDisplayed(increaseButton)
                    isDisplayed(sansSerifButton)
                    isDisplayed(serifButton)
                }
                ThemeChooserScreen.focusModeWidget {
                    isDisplayed(this)
                    isDisplayed(switch)
                    isDisplayed(description)
                }
                ThemeChooserScreen.themeWidget {
                    isDisplayed(this)
                    isDisplayed(lightButton)
                    isDisplayed(sepiaButton)
                    isDisplayed(darkButton)
                    isDisplayed(blackButton)
                    isDisplayed(matchSystemThemeSwitch)
                    isDisplayed(imageDimmingSwitch)
                }
            }
        }
    }

    @Test
    fun changeFontSize() {
        run {
            openThemeChooser()
            action.click(ThemeChooserScreen.fontWidget.increaseButton)
            verify {
                ThemeChooserScreen.fontWidget {
                    containsText(textSizePercent, "110")
                }
            }
            action.click(ThemeChooserScreen.fontWidget.decreaseButton)
            action.click(ThemeChooserScreen.fontWidget.decreaseButton)
            verify {
                ThemeChooserScreen.fontWidget {
                    containsText(textSizePercent, "90")
                }
            }
        }
    }

    @Test
    fun matchSystemThemeTogglesDarkButtons() {
        run {
            openThemeChooser()
            action.click(ThemeChooserScreen.themeWidget.matchSystemThemeSwitch)
            verify {
                ThemeChooserScreen.themeWidget {
                    isEnabled(darkButton)
                    isEnabled(blackButton)
                }
            }
            action.click(ThemeChooserScreen.themeWidget.matchSystemThemeSwitch)
            verify {
                ThemeChooserScreen.themeWidget {
                    isNotEnabled(darkButton)
                    isNotEnabled(blackButton)
                }
            }
        }
    }

    private fun TestContext<Unit>.openThemeChooser() {
        action.click(OnboardingScreen.skipButton)
        testRule.scenario.onActivity { activity ->
            ThemeChooserDialog.newInstance(Constants.InvokeSource.SETTINGS)
                .show(activity.supportFragmentManager, "ThemeChooser")
        }
        device.uiDevice.waitForIdle()
    }
}