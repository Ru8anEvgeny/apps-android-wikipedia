package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class OfflineCardV2(matcher: Matcher<View>) : KRecyclerItem<OfflineCardV2>(matcher) {

    val retry = KButton(matcher) {
        withId(R.id.view_card_offline_button_retry)
    }.name(withParent("Кнопка retry"))

    val textError = KTextView(matcher) {
        withText("Content cannot be loaded when offline")
    }.name(withParent("Текст ошибки"))
}