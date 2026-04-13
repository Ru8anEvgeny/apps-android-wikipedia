package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class InTheNewsItemV2(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItemV2>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }.name(withParent("Картинка"))

    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }.name(withParent("Текс"))

}