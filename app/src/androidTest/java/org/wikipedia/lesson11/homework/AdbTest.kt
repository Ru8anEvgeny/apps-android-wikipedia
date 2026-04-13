package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ArticleCardScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticle
import org.wikipedia.lesson8.homework.AnnouncementCard
import org.wikipedia.main.MainActivity
import java.util.Locale


class AdbTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRotationScreen() {
        run {
            step("Поворачиваем экран вправо") {
                device.uiDevice.setOrientationRight()
                Thread.sleep(3000)
            }

            step("Проверяем, что ротация не дефолтная") {
                Assert.assertFalse(device.uiDevice.isNaturalOrientation)
            }

            step("Ставим дефолтную ротации и проверяем что она стала дефолтной") {
                device.uiDevice.setOrientationNatural()
                Thread.sleep(2000)
                Assert.assertTrue(device.uiDevice.isNaturalOrientation)
                OnboardingScreen.skipButton.click()
                ExploreScreen.logo.isDisplayed()
            }
        }
    }

    @Test
    //выключение экрана, включение и проверка отображения элемента (любого)
    fun checkDisplayDown() {
        run {
            step("Отключаем экран") {
                device.uiDevice.sleep()
                Thread.sleep(3000)
            }

            step("включаем экран") {
                device.uiDevice.wakeUp()
            }
            step("Проверяем что элемент отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    //"свернуть" приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)
    fun checkResetApp() {
        run {
            step("Сворачиваем приложение") {
                device.uiDevice.pressHome()
            }

            step("рвзворачиваем приложение") {
                repeat(2) {
                    device.uiDevice.pressRecentApps()
                    Thread.sleep(3000)
                }
            }

            step("Проверяем отображение элемента") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    //выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry.
    // Включить сеть и нажать Retry, проверить отображение заголовка
    fun testInternetDisable() {
        before("Отключить и вернуть сеть") {
            adbServer.performAdb("shell svc data disable") // отключили инет
            adbServer.performAdb("shell svc wifi disable") // отключили вай фай
            Thread.sleep(5000)
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            step("Перейти на экран эксплоре") {
                OnboardingScreen.skipButton.click()
                ExploreScreen.items {
                    childWith<FeaturedArticle>{

                    }.perform {
                        image.click()
                    }
                }
                ArticleCardScreen {
                    textError.isDisplayed()
                    retry.isDisplayed()
                }
            }

            step("Включили сеть") {
                adbServer.performAdb("shell svc data enable")
                adbServer.performAdb("shell svc wifi enable")
            }

            step("Нажали на ретрай") {
                ArticleCardScreen.retry.click()
                ExploreScreen.items.isDisplayed()
            }

        }
    }

    @Test
    //поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)
    fun checkLanguagesEdit() {
        before("Смена языка приложения") {
            device.language.switchInApp(locale = Locale.FRENCH)
        }.after {
            device.language.switchInApp(locale = Locale.ENGLISH)
        }.run {
            OnboardingScreen.skipButton {
                hasText("Sauter")
            }
        }
    }

}