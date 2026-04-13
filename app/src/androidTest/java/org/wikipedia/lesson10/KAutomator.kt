package org.wikipedia.lesson10

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen1 : UiScreen<OnboardingUiScreen1>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen1.packageName, "fragment_onboarding_skip_button")
    }


}