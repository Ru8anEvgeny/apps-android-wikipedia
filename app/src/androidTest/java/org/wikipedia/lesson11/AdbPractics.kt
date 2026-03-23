package org.wikipedia.lesson11

import android.view.Surface
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

class AdbPractics() : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAdb() {
        run {
            device.uiDevice.setOrientationRight() // повернули девайс вправо
            Thread.sleep(3000) // подождать 3 сек
            val actual = device.uiDevice.getDisplayRotation() // получили текущую ротацию экрана
            val expected = Surface.ROTATION_270 // ожидаем ротацию 270
            Assert.assertEquals(expected, actual)

            repeat(2) { // повторить 2 раза
                device.uiDevice.setOrientationRight()
                Thread.sleep(300)
                device.uiDevice.setOrientationNatural()
            }

            Assert.assertEquals(expected, actual)


        }
    }

    @Test
    fun checkBeforeAfter() {
        before("название теста") {
            adbServer.performAdb("shell svc data disable") // отключили инет
            adbServer.performAdb("shell svc wifi disable") // отключили вай фай
        }.after {
            adbServer.performAdb("shell svc data enable") // включили инет
            adbServer.performAdb("shell svc wifi enable") // включили вай фай
        }.run {
            step("Нажимаем скип на экране онбординга") {
                OnboardingScreen.skipButton.click()
                Thread.sleep(10000)
            }
        }
    }


}

