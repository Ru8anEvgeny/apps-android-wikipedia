package org.wikipedia.lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher){
    val images = KImageView(parent = matcher) {
        isInstanceOf(AppCompatImageView::class.java)
        isDisplayed()
    }

    val searchText = KTextView(matcher){
        isInstanceOf(MaterialTextView::class.java)
        withId(R.string.search_hint)
    }
}