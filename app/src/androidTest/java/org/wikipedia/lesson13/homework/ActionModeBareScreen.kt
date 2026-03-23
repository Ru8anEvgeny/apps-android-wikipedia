package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object ActionModeBareScreen : KScreen<ActionModeBareScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val openNewButton = KButton {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }
}