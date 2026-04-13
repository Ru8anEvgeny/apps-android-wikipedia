package org.wikipedia.lesson19.homework

import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

object MoreMenuScreen : BaseScreen<MoreMenuScreen>() {

    override val screenName = "Меню More"

    val settingsButton = KView {
        withId(R.id.main_drawer_settings_container)
    }.name(withParent("Кнопка Settings"))
}