package org.wikipedia.lesson06

import com.google.android.material.button.MaterialButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

// Пейдж обжект - это шаблон в авттоматизированном тестировании который помогает организовать код. Он
// представляетс каждую страницу приложения как отдельный класс с элементами (кнопки, поля) и методами
// (клики, ввод текста)

object Onboarding : KScreen<Onboarding>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val image = KImageView {
        withId(R.id.imageViewCentered)
    }

    val primaryText = KTextView {
        withId(R.id.primaryTextView)
    }

    val appText = KTextView {
        containsText("following")
    }
    // поиск элеменента по родителю
    val addLanguagesButton = KButton {
        withParent{
            withId(R.id.languageListContainer)
        }
        // этот матчкер спрашивает у тебя есть предок?
        isDescendantOfA {
            withId(R.id.scrollViewContainer)
        }
        // метод проверяет что наш объект определенного класса
        isInstanceOf(MaterialButton::class.java)
    }
    // если элементов несколько используем индекс
    val firstLanguage = KTextView {
        withIndex(0) {
            withId(R.id.option_label)
        }
    }

    val tabButton = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }
}

fun main() {
    Onboarding {
        skipButton {
            isDisplayed()
            click()
        }

        tabButton.hasTabCount(4)
        tabButton.selectTab(2)
    }

}