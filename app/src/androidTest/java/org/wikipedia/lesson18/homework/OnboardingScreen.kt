package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.lesson8.PagerItem
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.invokeByIndex
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

object OnboardingScreen : BaseScreen<OnboardingScreen>() {

    override val screenName = "Экран онбординга"
    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }.name(withParent("Кнопка Skip"))

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }.name(withParent("Кнопка Continue"))

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    ).name(withParent("Слайдер"))

    // В OnboardinScreen можем добавить обёртку для доступа к слайдам
//    fun page(index: Int, fnc: PagerItem.() -> Unit) {
//        pager.invokeByIndex(index, fnc)
//    }

//    // Было
//    OnboardingScreen.pager.childAt<PagerItem>(2) {
//        image.isDisplayed()
//    }
//
//// Стало
//    OnboardingScreen.page(2) {
//        image.isDisplayed()
//    }

}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.imageViewCentered)
        }.name(withParent("Картинка"))
    }
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.primaryTextView)
        }.name(withParent("Заголовок"))
    }

    val addLanguageButton by lazy {
        KButton {
            withId(R.id.addLanguageButton)
        }.name(withParent("Кнопка добавления языка"))
    }

    val languages by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.languagesList)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        ).name(withParent("Список языков"))
    }
}

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<PagerItem>(matcher), TextViewAssertions