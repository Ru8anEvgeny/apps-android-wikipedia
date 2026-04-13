package org.wikipedia.lesson19.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.action
import org.wikipedia.lesson19.verify
import org.wikipedia.lesson8.homework.TopReadItem

class DslTest : BaseTest() {

    @Test
    fun topReadThirdItemImage() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItem>(2) {
                    verify.isDisplayed(image)
                }
            }
        }
    }

    @Test
    fun disableLinkPreviews() {
        run {
            action.click(OnboardingScreen.skipButton)
            action.click(ExploreScreen.moreTab)
            action.click(MoreMenuScreen.settingsButton)
            action.click(SettingsScreen.linkPreviewsSwitch)
            verify.isNotChecked(SettingsScreen.linkPreviewsSwitch)
        }
    }
}