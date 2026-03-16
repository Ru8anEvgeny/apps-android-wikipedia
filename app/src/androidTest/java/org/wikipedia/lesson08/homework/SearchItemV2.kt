package org.wikipedia.lesson8.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
class SearchItemV2(matcher: Matcher<View>) : KRecyclerItem<SearchItemV2>(matcher) {

    val icon = KImageView(matcher) {
        withContentDescription("Search Wikipedia")
    }

    val textSearch = KTextView(matcher){
        withText(R.string.search_hint)
    }

    val voiceIcon = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }
}