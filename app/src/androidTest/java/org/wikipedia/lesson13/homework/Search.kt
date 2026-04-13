package org.wikipedia.lesson13.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.views.WikiCardView

class Search(matcher: Matcher<View>) : KRecyclerItem<Search>(matcher) { // поиск на главном экране

    val searchText = KTextView(matcher) {
        isInstanceOf(WikiCardView::class.java)
        withText("Search Wikipedia")
    }

    val voice = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }





}