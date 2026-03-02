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

class AnnouncementItem(matcher: Matcher<View>) : KRecyclerItem<AnnouncementItem>(matcher) {
    val card = KView(matcher){
        isInstanceOf(WikiCardView::class.java)
    }

    val image = KImageView(matcher){
        withId(R.id.view_announcement_header_image)
    }

    val customizeText = KTextView(matcher){
        withId(R.id.view_announcement_text)
    }

    val customizeButton = KButton(matcher){
        withId(R.id.view_announcement_action_positive)
    }

    val goItButton = KButton(matcher){
        withId(R.id.view_announcement_action_negative)
    }
}