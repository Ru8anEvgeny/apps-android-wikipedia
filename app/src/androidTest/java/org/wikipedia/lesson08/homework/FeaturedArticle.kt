package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {

    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val image = KImageView(matcher) {
        withId(R.id.articleImage)
    }

    val contentTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }

    val contentDescription = KTextView(matcher) {
        withId(R.id.articleDescription)
    }

    val contentText = KTextView(matcher) {
        withId(R.id.articleExtract)
    }

    val toDay = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }

    val retry = KButton(matcher) {
        withId(R.id.view_card_offline_button_retry)
    }

    val textError = KTextView(matcher) {
        withText("Content cannot be loaded when offline")
    }


}