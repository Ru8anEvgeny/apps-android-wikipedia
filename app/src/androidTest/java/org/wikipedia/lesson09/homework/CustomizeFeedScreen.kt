package org.wikipedia.lesson09.homework

import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object CustomizeFeedScreen : KScreen<CustomizeFeedScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val toolbarUpButton = KImageView {
        withContentDescription("Navigate up")
    }
    val textToolbar = KTextView{
        withText("Customize the feed")
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::ConfigureItem)
        }
    )



}