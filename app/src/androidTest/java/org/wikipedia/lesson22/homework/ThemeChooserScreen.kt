package org.wikipedia.lesson22.homework

import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name

object ThemeChooserScreen : BaseScreen<ThemeChooserScreen>() {

    override val screenName = "Боттомшит настроек темы"

    val fontWidget by lazy {
        FontWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет настройки шрифта"))
    }

    val focusModeWidget by lazy {
        FocusModeWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет Reading focus mode"))
    }

    val themeWidget by lazy {
        ThemeWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет темы"))
    }
}