package org.wikipedia.lesson09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.NewsItem
import org.wikipedia.lesson08.homework.NewsList
import org.wikipedia.main.MainActivity

class PracticTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        run("") {
            OnboardingScreen {
                step("Нажимает на кнопку скип") {
                    skipButton.click()
                }
            }

            ExploreScreen.items.childWith<NewsItem>{
                isInstanceOf(NewsCardView::class.java)// isInstanceOf класс родитель
            } perform {
                headerTitle.hasText("In the news")
                newsList.childAt<NewsList>(2){
                    image.isDisplayed()
                }
            }

        }
    }

}