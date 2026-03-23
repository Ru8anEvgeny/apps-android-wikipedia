package org.wikipedia.lesson09.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class PagerItems(matcher: Matcher<View>) : KViewPagerItem<PagerItems>(matcher) {

    val image = KImageView {
        withId(R.id.imageViewCentered)
    }

    val primaryText = KTextView {
        withId(R.id.primaryTextView)
    }

    val secondaryText = KTextView{
        withId(R.id.secondaryTextView)
    }

    val languageList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languageListContainer)
        },
        itemTypeBuilder = {
            itemType(::LanguageItems)
        }

    )
}