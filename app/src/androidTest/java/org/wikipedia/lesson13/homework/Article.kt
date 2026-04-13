package org.wikipedia.lesson13.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class Article(matcher: Matcher<View>) : KRecyclerItem<Article>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_featured_article_card_header)
    }

    val articleImage = KImageView(matcher) {
        withId(R.id.articleImage)
    }

    val articleTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }

    val articleDescription = KTextView(matcher) {
        withId(R.id.articleDescription)
    }

    val articleText = KTextView(matcher) {
        withId(R.id.articleExtract)
    }

    val todayOnWikiButton = KButton(matcher) {
        withId(R.id.footerActionButton)
    }
}