package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.web.KWebView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebView() {
        run {
            ArticleScreen {
                webView {
                    withElement(Locator.CLASS_NAME, "mw-page-title-main") { // локатор по классу
                        scroll()
                        hasText("Loveday")
                    }
                }

                webView {
                    withElement(Locator.XPATH, "(//img)[1]") { // обратились к элементу по XPATH
                        scroll()
                        click()
                    }
                }

            }
        }
    }

}

object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }
}