package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson22.KWidget

class ThemeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeWidget>(builder) {

    val lightButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_light)
        }.name(withParent("Тема Light"))
    }

    val sepiaButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_sepia)
        }.name(withParent("Тема Sepia"))
    }

    val darkButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Тема Dark"))
    }

    val blackButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Тема Black"))
    }

    val matchSystemThemeSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Переключатель Match system theme"))
    }

    val imageDimmingSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_dark_mode_dim_images_switch)
        }.name(withParent("Переключатель Image dimming"))
    }
}