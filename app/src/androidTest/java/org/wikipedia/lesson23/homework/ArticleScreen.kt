package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen

object ArticleScreen : BaseScreen<ArticleScreen>() {
    override val screenName = "Экран статьи"

    private val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val title by lazy {
        webView.withXPath("//h1")
            .name(withParent("Заголовок"))
    }

    val references by lazy {
        webView.withXPath("//*[@id=\"References\"]")
            .name(withParent("Блок References"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "//ol")
            .name(withParent("Список"))
    }

    fun referenceItem(index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}