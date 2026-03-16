package org.wikipedia.lesson8.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen : KScreen<ExploreScreen>() {

    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass: Class<*> = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val closeButton = KImageView {
        withId(R.id.closeButton)
    }

    val items = KRecyclerView(

        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItemV2)
            itemType(::CustomizeItem)
            itemType(::DataItem)
            itemType(::TopRead)
            itemType(::InTheNews)
            itemType(::FeaturedArticle)
            itemType(::AnnouncementCard)
            itemType(::OfflineCard)
        }
    )
}