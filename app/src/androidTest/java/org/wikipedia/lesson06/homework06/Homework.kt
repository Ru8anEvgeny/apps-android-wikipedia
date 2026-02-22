package org.wikipedia.lesson06.homework06

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.theme.Theme
import org.wikipedia.R

object ThemeScreen : KScreen<ThemeScreen>(){
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSettingsCategory = KTextView{
        withId(R.id.textSettingsCategory)
    }

    val textSizePercent = KTextView{
        withId(R.id.text_size_percent)
    }

    val buttonDecreaseTextSize = KButton {
        withId(R.id.buttonDecreaseTextSize)
    }

    val buttonIncreaseTextSize = KButton {
        withId(R.id.buttonIncreaseTextSize)
    }

    val sizeTextBar = KToolbar {
        withId(R.id.text_size_seek_bar)
    }

    val sansSerifButton = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val serifButton = KButton {
        withId(R.id.button_font_family_serif)
    }

    val imageView = KImageView {
        withParent{
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val focusModeSwitch = KCheckBox {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val focusModeDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val themeKTextView = KTextView {
        withText("Theme")
    }

    val lightThemeButton = KButton {
        withId(R.id.button_theme_light)
    }

    val sepiaThemeButton = KButton {
        withId(R.id.button_theme_sepia)
    }

    val darkThemeButton = KButton {
        withId(R.id.button_theme_dark)
    }

    val blackThemeButton = KButton {
        withId(R.id.button_theme_black)
    }

    val checkBoxMathSystemTheme = KCheckBox {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val checkBoxDarkMode = KCheckBox {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }




}