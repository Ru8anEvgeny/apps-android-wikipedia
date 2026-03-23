package org.wikipedia.lesson09.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingFragment

object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId: Int = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*> = OnboardingFragment::class.java

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItems)
        }
    )

    val skip = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton{
        withId(R.id.fragment_onboarding_done_button)
    }













}