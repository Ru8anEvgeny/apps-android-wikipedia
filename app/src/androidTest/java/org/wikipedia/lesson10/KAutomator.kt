package org.wikipedia.lesson10

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }


}