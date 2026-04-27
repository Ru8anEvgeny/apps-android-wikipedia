package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.edit.EditableActions
import org.wikipedia.lesson18.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {
    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun typeText(element: EditableActions, text: String) {
        steps.typeText(
            "Вводит текст '$text' в '${(element as BaseActions).getName()}'",
            element,
            text
        )
    }

    fun click(element: KWebViewElement) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }
}