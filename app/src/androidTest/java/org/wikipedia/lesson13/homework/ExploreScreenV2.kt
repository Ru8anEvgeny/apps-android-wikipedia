package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.bottomnav.KBottomNavigationView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R


object ExploreScreenV2 : KScreen<ExploreScreenV2>() { // Главный экран
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val imageWiki = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val tabExplore = KView {
        withId(R.id.nav_tab_explore)
    }

    val savedTab = KView {
        withId(R.id.nav_tab_reading_lists)
    }

    val searchTab = KView {
        withId(R.id.nav_tab_search)
    }

    val tabActivity = KView {
        withId(R.id.nav_tab_edits)
    }

    val moreTab = KView {
        withId(R.id.nav_tab_more)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view) // ид ресайклера
        },
        itemTypeBuilder = { // список классов самих элементов
            itemType(::Search)
            itemType(::Customize)
            itemType(::WikiGames)
            itemType(::ActualDate)
            itemType(::Article)

        }
    )
}