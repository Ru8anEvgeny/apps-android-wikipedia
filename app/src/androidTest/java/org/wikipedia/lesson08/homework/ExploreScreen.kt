package org.wikipedia.lesson08.homework
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.textview.MaterialTextView
import org.wikipedia.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.feed.view.FeedView
import org.wikipedia.views.WikiCardView

object ExploreScreen : KScreen<ExploreScreen>(){ // создаем описание главного экрана
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    // ресайтлер - это списочный элемент

    val logo = KImageView{
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView(
        builder = {
           withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::AnnouncementItem)
            itemType(::TopReadItem)
        }
    )
}

