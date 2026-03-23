package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.ArticleCardScreen
import org.wikipedia.lesson08.homework.FeaturedArticle
import org.wikipedia.lesson09.homework.OnboardingScreen
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.main.MainActivity
import java.util.Locale


class AdbTestsV2class : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkRetry() {
        before("Проверка работы без сети") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
            Thread.sleep(3000)
            OnboardingScreen.skip.click()
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
            Thread.sleep(3000)
        }.run {
            step("Перешли в Featured Article") {
                ExploreScreen {
                    items {
                        childWith<FeaturedArticle> {
                        } perform {
                            contentTitle.click()
                        }
                    }
                }
            }
            step("Проверили Retry и текст ошибки") {
                ArticleCardScreen {
                    retry.isDisplayed()
                    textError.isDisplayed()
                }
            }
            step("Включить сеть") {
                adbServer.performAdb("shell svc data enable")
                adbServer.performAdb("shell svc wifi enable")
                Thread.sleep(3000)
            }
            step("Тап на Retry") {
                ArticleCardScreen {
                    retry.click()
                }
            }
        }
    }

    @Test
    fun checkLanguage() {
        before(testName = "поменять язык приложения и проверить текст") {
            device.language.switchInApp(locale = Locale.FRENCH)
            Thread.sleep(3000)
        }.after {
            device.language.switchInApp(locale = Locale.ENGLISH)
        }.run {
            OnboardingScreen.skip.hasText(text = "Sauter")
        }
    }

    @Test
    fun checkActivities() {
        OnboardingScreen.skip.click()
        Assert.assertEquals(
            "org.wikipedia.main.MainActivity",
            device.activities.getResumed()?.javaClass?.name
        )
    }
}