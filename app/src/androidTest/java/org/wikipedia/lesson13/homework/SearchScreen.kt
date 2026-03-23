package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val back = KImageView() {
        withContentDescription("Navigate up")
    }

    val engTab = KTextView {
        withId(R.id.language_label)
        withText("English")
    }

    val ruTab = KTextView {
        withId(R.id.language_label)
        withText("русский")
    }

    val more = KButton {
        withId(R.id.more_languages)
    }

    val search = KEditText {
        withId(androidx.appcompat.R.id.search_src_text)
    }


}