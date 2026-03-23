package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object WebScreen : KScreen<WebScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }



}