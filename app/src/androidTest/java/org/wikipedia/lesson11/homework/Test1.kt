package org.wikipedia.lesson11.homework

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson8.homework.SearchItemV2
import org.wikipedia.lesson09.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class Test1 : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setup() {
        OnboardingScreen.skip.click()
        try {
            ExploreScreen.closeButton.click()
        } catch (_: Exception) {
        }
    }

    @After
    fun teardown() {
        device.uiDevice.setOrientationNatural()
    }

    @Test
    fun checkOrientation() {
        run {
            step("Повернули девайс вправо") {
                device.uiDevice.setOrientationRight()
                try {
                    ExploreScreen.closeButton.click()
                } catch (_: Exception) {
                }
                Assert.assertFalse(device.uiDevice.isNaturalOrientation)
            }
            step("Проверили что поиск виден") {
                ExploreScreen {
                    items {
                        childWith<SearchItemV2> {
                            withDescendant { withText("Search Wikipedia") }
                        } perform {
                            icon.isDisplayed()
                            textSearch.isDisplayed()
                            voiceIcon.isDisplayed()
                        }
                    }
                }
            }
            step("Вернули в портрет") {
                device.uiDevice.setOrientationNatural()
                Assert.assertTrue(device.uiDevice.isNaturalOrientation)
            }
        }
    }

    @Test
    fun checkStartStop() {
        run {
            step("Выключили дисплей") {
                device.uiDevice.sleep()
                Assert.assertFalse(device.uiDevice.isScreenOn)
                Thread.sleep(2000)
            }
            step("Включили дисплей") {
                device.uiDevice.wakeUp()
                Assert.assertTrue(device.uiDevice.isScreenOn)
                Thread.sleep(2000)
            }
            step("Проверили блок поиска") {
                ExploreScreen {
                    items {
                        childWith<SearchItemV2> {
                            withDescendant { withText("Search Wikipedia") }
                        } perform {
                            icon.isDisplayed()
                            textSearch.isDisplayed()
                            voiceIcon.isDisplayed()
                        }
                    }
                }
            }
        }
    }

    @Test
    fun checkHomeRecentApps() {
        run {
            step("Перешли на экран домой") {
                device.uiDevice.pressHome()
                Assert.assertNotEquals("org.wikipedia.alpha", device.uiDevice.currentPackageName)
            }
            step("Вернулись в приложение") {
                device.uiDevice.pressRecentApps()
                Thread.sleep(3000)
                device.uiDevice.pressRecentApps()
                Thread.sleep(3000)
                Assert.assertEquals("org.wikipedia.alpha", device.uiDevice.currentPackageName)
            }
            step("Проверили блок поиска") {
                ExploreScreen {
                    items {
                        childWith<SearchItemV2> {
                            withDescendant { withText("Search Wikipedia") }
                        } perform {
                            icon.isDisplayed()
                            textSearch.isDisplayed()
                            voiceIcon.isDisplayed()
                        }
                    }
                }
            }
        }
    }

}