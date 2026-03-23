package org.wikipedia.lesson09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.LanguageItem
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.PagerItem
import org.wikipedia.main.MainActivity

// тест кейсы пишутся в тестовых классах - наследование от TestCase kaspresso
class SimpleTest : TestCase() {

    // спец конструкция для того что бы открывать активити в тесте
    @get:Rule // рул - компонент который будет выполняться до запуска основного тест сценария.
    val testRule = ActivityScenarioRule(MainActivity::class.java)
    //ActivityScenarioRule - класс который запускает активити приложения

    //все тестовые методы должны начинаться с анотации тест
    @Test
    // тестовый метод
    fun checkOnboardingScreen() {
        // каждый тестовый метод начинается с run - спец метод, принимает название теста и набор шагов
        run("Кнопка Skip отображается на экране онбординга") {
            // далее обращаемся к экрану на котором хотим что-то сделать
            OnboardingScreen {
                step("Проверяет что кнопка Skip отображается") {
                    skipButton.isDisplayed()// тут проверили, что на экране OnboardingScreen отображается кнопка skipButton
                    skipButton.hasAnyText() // содердит любой произвольный текс
                    skipButton.hasText("Skip")// содержит текст скип

                    //можно писать так
                    skipButton {
                        isDisplayed()
                        hasAnyText()
                        hasText("Skip")
                    }
                }
                step("Нажимает на кнопку continuaButton ") {
                    continuaButton.click() // нажали на кнопку continuaButton
                }

                step("Проверяет, что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }

            }

            //списочные эелементы. Можем обращаться к объекту пейджера и вызывать методо chaildAt -
            // это дочерний элемент находящийся на позиции
            OnboardingScreen.pager{
                isDisplayed() // проверили что pager в принципе отображается

                childAt<PagerItem>(3) {// т.е 3 - это 4й слайд
                    // Требует указания класса этого блока <PagerItem>
                    // дальше можем на прямую в {} обращаться к элементам класса PagerItem

                    // проверяем, что на последнем слайде картинка отображается
                    image.isDisplayed()

                    //проверяем, что заголовок на 4м слайде содержит текст Data
                    title.containsText("Data")
                }

                childAt<PagerItem>(1) {
                    title.containsText("explore")
                }


                childAt<PagerItem>(0) {
                    // ображаемся к списочному элементу PagerItem
                    // у PagerItem есть languages. languages - это тоже списочный элемент внутри списка

                    languages.childAt<LanguageItem>(0){
                        // так же через childAt обращаемся  к списочному
                        containsText("English")
                    }
                }

                // У Пейджеров есть только метод childAt
                // У ресайтлеров есть несколько разных методов которые позволяют обращаться
                // к элементам списка

                childAt<PagerItem>(0){
                     languages.childWith<LanguageItem> { // childWith принимает тип и принимает вью билдер
                        containsText("English") // тут containsText возвращает объект который содержит English
                    }

                    // условно если бы было несколько языков. то с помощью childWith мы бы забрали из списка конкретный
                    // элемент. И что бы дальше с ним работать можно использовать перформ

                    languages.childWith<LanguageItem> {
                        containsText("English")
                    } perform {
                        isDisplayed()
                        hasText("1.\t\tEnglish")
                    }

                }
            }
        }
    }

}