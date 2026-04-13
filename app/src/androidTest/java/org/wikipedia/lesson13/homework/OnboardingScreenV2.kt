package org.wikipedia.lesson13.homework

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreenV2 : KScreen<OnboardingScreenV2>() {
    override val layoutId: Int? //это ID файла разметки (layout), который отображается на экране
        get() = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*>? // это класс экрана
        get() = OnboardingPageView::class.java
    
    val pagers = KViewPager2( // // это "список экранов", который листает свайпами вправо-влево
        builder = {
            withId(R.id.fragment_pager) // ID ViewPager2 из Layout
        },
        itemTypeBuilder = {
            itemType(::PagerItems) // класс для ЭЛЕМЕНТОВ внутри ViewPager2
        }
    )

    fun swipePagerRight() { // функция для свайпа экрана вправо
        pagers {
            swipeRight()
        }
    }

    fun swipePagesLeft() { // функция для свайпа экрана влево
        pagers {
            swipeLeft()
        }
    }

    val skipButton = KButton { // кнопка скип
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton { // кнопка континье
        withId(R.id.fragment_onboarding_done_button)
    }

    val tab = KTabLayout { // таб
        withId(R.id.view_onboarding_page_indicator)
    }
}

class PagerItems(matcher: Matcher<View>) : KViewPagerItem<PagerItems>(matcher) {

    val image = KImageView(matcher) { // картинка в центре
        withId(R.id.imageViewCentered)
    }

    val primaryText = KTextView(matcher) { // крупный текст
        withId(R.id.primaryTextView)
    }

    val secondaryText = KTextView(matcher) { // текст мелким шрифтом
        withId(R.id.primaryTextView)
    }

    val addLanguagesButton = KButton(matcher) { // кнопка добавить текст
        withId(R.id.addLanguageButton)
    }

    val languagesList = KRecyclerView( // список языков
        parent = matcher,
        builder = {
            withId(R.id.languagesList) // id элемента списка из лояута
        },
        itemTypeBuilder = {
            itemType(::LanguagesList) // класс в котором объявлены элементы списка языков
        }
    )



}

class LanguagesList(matcher: Matcher<View>) : KRecyclerItem<LanguagesList>(matcher), TextViewAssertions {
    val languages = KTextView(matcher) { // язык
        withId(R.id.option_label)
    }
}
