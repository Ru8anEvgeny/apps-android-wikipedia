package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson8.homework.InTheNewsItem

class InTheNewsV2(matcher: Matcher<View>) : KRecyclerItem<InTheNewsV2>(matcher) {

    val headerText = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }.name(withParent("Заголовок"))

    val menu = KImageView(matcher){
        withId(R.id.view_list_card_header_menu)
    }.name(withParent("Иконка меню"))

    val items = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::InTheNewsItem)
        }
    ).name(withParent("Новости"))
}