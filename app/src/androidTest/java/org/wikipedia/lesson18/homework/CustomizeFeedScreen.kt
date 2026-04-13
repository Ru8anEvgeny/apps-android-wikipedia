package org.wikipedia.lesson18.homework

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name
import org.wikipedia.lesson8.homework.CustomizeItem

object CustomizeFeedScreen : BaseScreen<CustomizeFeedScreen>() {
    override val screenName = "Экран Customize Feed"


    val back = KImageView() {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }.name(withParent("Иконка кнопки назад"))

    val title = KTextView() {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatTextView::class.java)
    }.name(withParent("Заголовок текст"))

    val menu = KImageView() {
        withContentDescription("More options")
    }.name(withParent("Иконка меню"))



    val items =  KRecyclerView(

        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeItem)
        }
    ).name(withParent("Тогл контента"))
}