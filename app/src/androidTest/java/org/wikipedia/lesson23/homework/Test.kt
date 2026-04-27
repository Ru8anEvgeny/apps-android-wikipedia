package org.wikipedia.lesson23.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson8.homework.TopReadItem

class Test : BaseTest() {

    @Test
    fun test() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItem>(0) {
                    action.click(this)
                    Thread.sleep(3000)
                }
            }
            verify.isDisplayed(ArticleScreen.title)
            action.click(ArticleScreen.references)
            ArticleScreen.referenceItem(2) {
                verify.hasText(index, "[2]")
            }
        }
    }
}