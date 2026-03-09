package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.views.WikiCardView

class AnnouncementItem(parent: Matcher<View>) : KRecyclerItem<AnnouncementItem>(parent) {
    val card = KView(parent) {
        isInstanceOf(WikiCardView::class.java)
    }

    val image = KImageView(parent) {
        withId(R.id.view_announcement_header_image)
    }

    val customizeText = KTextView(parent) {
        withId(R.id.view_announcement_text)
    }

    val customizeButton = KButton(parent) {
        withId(R.id.view_announcement_action_positive)
    }

    val goItButton = KButton(parent) {
        withId(R.id.view_announcement_action_negative)
    }
}