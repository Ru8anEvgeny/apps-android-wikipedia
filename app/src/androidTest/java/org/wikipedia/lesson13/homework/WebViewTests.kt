package org.wikipedia.lesson13.homework
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.SearchItemV2
import org.wikipedia.main.MainActivity


class WebViewTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkWebViewV2() {
        run {
            OnboardingScreen {
                step("Нажимает Skip на экране онбординга") {
                    skipButton {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Если показался  поп ап Вики Геймс") {
                try {
                    ExploreScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
            step("Клик по поиску") {
                ExploreScreen {
                    items {
                        childWith<SearchItemV2> {
                            withDescendant { withContentDescription("Search Wikipedia") }
                        } perform {
                            textSearch.click()
                        }
                    }
                }
            }
            step("Пишем в поиске Vk") {
                SearchScreen.search.typeText("Vk")
            }
            step("Тап по первой статье") {
                device.uiDevice.findObject(UiSelector().text("Vk")).click()
                //закрыли вики геймс
                try {
                    ExploreScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
            step("Скролим до References проверяем текст") {
                WebScreen.webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
            }
            step("Скролим до 5й ссылки и тапаем") {
                WebScreen.webView {
                    withElement(
                        Locator.XPATH,
                        "//*[@id=\"cite_ref-FOOTNOTEMurray202024-29_5-0\"]/a/span"
                    ) {
                        scroll()
                        click()
                        Thread.sleep(3000)
                    }
                }
            }
            step("Проверили заголовок") {
                ReferencesScreen.title.hasText("Reference ")
            }
            step("Проверяем что ссылка под номером 5") {
                ReferencesScreen.refId.hasText("5.")
            }
            step("Тап назад") {
                device.uiDevice.pressBack()
                Thread.sleep(3000)
            }
            step("Нашли 2ю ссылку"){
                WebScreen.webView{
                    withElement(Locator.XPATH,"//*[@id=\"pcs\"]/section[1]/p[4]/a[24]"){
                        scroll()
                        Thread.sleep(3000)
                        click()
                    }
                }
            }
            step("Тап на Read article"){
                ActionModeBareScreen.readArticleButton.click()
            }
        }
    }
}