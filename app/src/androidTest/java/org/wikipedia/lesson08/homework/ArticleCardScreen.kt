package org.wikipedia.lesson08.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ArticleCardScreen: KScreen<ArticleCardScreen>() {

    override val layoutId: Int = 0

    override val viewClass: Class<*> = FeedView::class.java


    val retry = KButton {
        withText("Content cannot be loaded when offline.")
    }

    val textError = KTextView {
        withId(R.id.view_card_offline_button_retry)
    }
}