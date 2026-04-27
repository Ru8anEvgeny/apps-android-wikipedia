package org.wikipedia.lesson23.homework

abstract class StepsDsl<T : StepsDsl<T>> {

    abstract val self: T

    operator fun invoke(fnc: T.() -> Unit) {
        self.fnc()
    }
}