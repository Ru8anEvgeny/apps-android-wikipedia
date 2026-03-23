package org.wikipedia.lesson10.homework

import com.google.android.material.textview.MaterialTextView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object KAutomatorOnboardingScreen : UiScreen<KAutomatorOnboardingScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@KAutomatorOnboardingScreen.packageName, "fragment_onboarding_skip_button" )
    }

    val continueButton = UiButton {
        withId(this@KAutomatorOnboardingScreen.packageName, "fragment_onboarding_forward_button")
    }

    val image = UiView {
        withId(this@KAutomatorOnboardingScreen.packageName, "imageViewCentered")
    }

    val addLanguagesButton = UiButton {
        withId(this@KAutomatorOnboardingScreen.packageName, "addLanguageButton")
    }

    val secondaryText = UiTextView {
        withId(this@KAutomatorOnboardingScreen.packageName, "secondaryTextView")
    }

    val primaryText = UiTextView {
        withId(this@KAutomatorOnboardingScreen.packageName, "primaryTextView")
    }

    val languages = UiTextView {
        withId(this@KAutomatorOnboardingScreen.packageName, "option_label")
    }

}