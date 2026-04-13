package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class FeaturedArticleV2(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleV2>(matcher) {

    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }.name(withParent("Заголовок"))

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }.name(withParent("Иконка меню"))

    val image = KImageView(matcher) {
        withId(R.id.articleImage)
    }.name(withParent("Картинка"))

    val contentTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }.name(withParent("Заголовок контента"))

    val contentDescription = KTextView(matcher) {
        withId(R.id.articleDescription)
    }.name(withParent("Дескрипшн контента текстом"))

    val contentText = KTextView(matcher) {
        withId(R.id.articleExtract)
    }.name(withParent("Текст контента"))

    val toDay = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }.name(withParent("toDay текст"))

    val retry = KButton(matcher) {
        withId(R.id.view_card_offline_button_retry)
    }.name(withParent("Кнопка retry"))

    val textError = KTextView(matcher) {
        withText("Content cannot be loaded when offline")
    }.name(withParent("Текст ошибки"))


}