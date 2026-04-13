package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.main.MainActivity
import org.wikipedia.R
import org.wikipedia.lesson8.homework.AnnouncementCard


class Tests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFeaturedArticleNotExist() = run {
        step("Нажимает Skip на экране онбординга") {
            OnboardingScreen {
                skipButton.click()
            }
        }

        step("Проверяет отображение блока Featured Article экрана Explore") {
            ExploreScreen.items {
                childWith<AnnouncementCard> {
                    withDescendant {
                        withId(R.id.view_announcement_text)
                        containsText("Customize")
                    }
                } perform {
                    image.isDisplayed()
                    text.isDisplayed()
                    gotIt.isDisplayed()
                    customize.isDisplayed()
                }
            }
        }

        step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
            ExploreScreen.items {
                childWith<AnnouncementCard> {
                    withDescendant {
                        withId(R.id.view_announcement_text)
                        containsText("Customize")
                    }
                } perform {
                    customize.click()
                }
            }
        }

        step("Отключает Featured Article") {
            CustomizeFeedScreen {
                toolbar.isDisplayed()
                textToolbar.isDisplayed()

                items.childWith<ConfigureItem> {
                    withDescendant {
                        withId(R.id.feed_content_type_title)
                        containsText("Featured article")
                    }
                }.perform {
                    image.isDisplayed()
                    subtitle.isDisplayed()
                    checkBox.click()
                }
            }
        }

        step("Нажимает стрелку назад в верхнем тулбаре") {
            CustomizeFeedScreen {
                toolbar.isDisplayed()
                toolbarUpButton.click()
            }
        }

        step("Проверяет, что блок Featured Article не отображается на экране Explore (doesNotExist)") {
            ExploreScreen {
                logo.isDisplayed()

                items.childWith<AnnouncementCard> {
                    withDescendant {
                        withText("Customize")
                    }
                } perform {
                    doesNotExist()
                }
            }

        }
    }
}