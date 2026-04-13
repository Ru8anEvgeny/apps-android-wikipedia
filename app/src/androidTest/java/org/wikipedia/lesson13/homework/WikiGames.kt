package org.wikipedia.lesson13.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikiGames(matcher: Matcher<View>) : KRecyclerItem<WikiGames>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val listCardHeader = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val titleHeader = KTextView(matcher) {
        withId(R.id.viewWikiGamesCardTitle)
    }

    val subtitleHeader = KTextView(matcher) {
        withId(R.id.viewWikiGamesCardSubTitle)
    }

    val image = KImageView(matcher) {
        withId(R.id.viewWikiGamesCardImage)
    }
}