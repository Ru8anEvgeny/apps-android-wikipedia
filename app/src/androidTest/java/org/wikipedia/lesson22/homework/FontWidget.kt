package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson22.KWidget

class FontWidget(builder: ViewBuilder.() -> Unit) : KWidget<FontWidget>(builder) {

    val textSizePercent by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Процент размера шрифта"))
    }

    val decreaseButton by lazy {
        KButton(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения шрифта"))
    }

    val increaseButton by lazy {
        KButton(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения шрифта"))
    }

    val sansSerifButton by lazy {
        KButton(matcher) {
            withId(R.id.button_font_family_sans_serif)
        }.name(withParent("Кнопка sans-serif"))
    }

    val serifButton by lazy {
        KButton(matcher) {
            withId(R.id.button_font_family_serif)
        }.name(withParent("Кнопка serif"))
    }
}