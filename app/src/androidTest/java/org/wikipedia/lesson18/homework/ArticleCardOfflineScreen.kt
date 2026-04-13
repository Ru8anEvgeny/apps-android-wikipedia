package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name

object ArticleCardOfflineScreen : BaseScreen<ArticleCardOfflineScreen>() {
    override val screenName = "Акртикал офлайн экран"

    val retry = KButton {
        withText("Cannot connect to internet")
    }.name(withParent("Кнопка retry"))

    val textError = KTextView {
        withText("Cannot connect to internet")
    }.name(withParent("Текст ошибки"))

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }
}