package org.wikipedia.lesson19.homework

import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.check.KCheckBox
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

object SettingsScreen : BaseScreen<SettingsScreen>() {

    override val screenName = "Экран настроек"

    val linkPreviewsSwitch = KCheckBox {
        isDescendantOfA {
            withMatcher(ViewMatchers.hasDescendant(ViewMatchers.withText("Show link previews")))
        }
        isInstanceOf(android.widget.CompoundButton::class.java)
    }.name(withParent("Тогл Show link previews"))
}