package org.wikipedia.lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withParent
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {
    val headerTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val imageHeader = KImageView(matcher){
        isInstanceOf(AppCompatImageView::class.java)
        isDisplayed()
    }

    val newsList = KRecyclerView(
        builder = {
            withParent(matcher)
            withId(R.id.news_cardview_recycler_view)

        },
        itemTypeBuilder = {
            itemType(::NewsList)
        }
    )
}