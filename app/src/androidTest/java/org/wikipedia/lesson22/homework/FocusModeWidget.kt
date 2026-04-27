package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson22.KWidget

class FocusModeWidget(builder: ViewBuilder.() -> Unit) : KWidget<FocusModeWidget>(builder) {

    val switch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Переключатель Reading focus mode"))
    }

    val description by lazy {
        KTextView(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_description)
        }.name(withParent("Описание Reading focus mode"))
    }
}