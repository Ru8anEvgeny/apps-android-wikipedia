package org.wikipedia.lesson03.homework03

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)

val imageViewCentered = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

val primaryText = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.search_empty_message
)

val secondaryText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_multilingual_secondary_text
)

val optionLabel = listOf(
    AppTextView::class.java,
    R.id.option_label
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)

val getStartedButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_done_button,
    R.string.onboarding_get_started
)
