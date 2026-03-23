package org.wikipedia.lesson11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class AdbTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAdb() {
        run {
            //device.uiDevice.click() - сожно кликнуть по какойт-то кнопке если через каспрессо не получается
            //device.uiDevice.swipe() - свайп
            //device.uiDevice.dumpWindowHierarchy() - можно вытащить дамп экрана и сохр в файл
            // можно добраться до объекта так
            device.uiDevice.findObject(UiSelector().scrollable(true))
                .click()
            adbServer.performShell( // adbServer - объект который хранит команды например performShell.
                command = "echo", // передаем команду echo
                arguments = listOf( // список аргументов. Аргументы разделяемые пробелом идут одельной строкой
                    "Hello from Kaspresso",
                    ">",
                    "/sdcard/kaspresso_test.txt"
                )
            )

            adbServer.performAdb(
                command = "pull",
                arguments = listOf(
                    "/sdcard/kaspresso_test.txt",
                    "./kaspresso_test.txt"
                )
            )
        }
    }

    // before - пред условие сценария. Что надо выполнить до того как сценарий запустится
    // after - пост условия. Что выполнить по завершению сценария
    @Test
    fun preAndPostScenario() {
        before("Название теста") {
            device.network.toggleMobileData(false)
            device.network.toggleWiFi(false)
        }.after {
            device.network.toggleMobileData(true)
            device.network.toggleWiFi(true)
        }.run {
            // код сценария
        }
    }
}

//Доступ к большинству из этих функций предоставляется через объект device, который хранит в себе набор объектов с конфигурацией под специфичные функции девайса:
//accessibility - включает и отключает сервис accessibility;
//activities - получение текущей открытой активити и проверка класса активити, что он сейчас является текущим;
//apps - установка и удаление приложений, открытие ссылки в Chrome, запуск приложения, работа с недавними открытыми приложениями, завершение приложения;
//exploit - вращение девайса, кнопки "назад" и "домой";
//files - загрузка, выгрузка и удаление файлов на девайсе;
//hackPermissions - выдача приложению доступов (например доступ к файловой системе или контактам);
//keyboard - печать символов через программную клавиатуру девайса;
//language - установка языка в приложении или в системе;
//location - включение и отключение GPS, установка фиктивной геолокации;
//logcat - функции для работы с логами девайса (чтение с фильтрацией, очистка);
//network - включает и отключает сеть (Wi-Fi и мобильные данные);
//permissions - разрешает или отказывает в выдаче разрешений запрошенных через диалог;
//phone - эмулирует телефонный вызов или получение СМС, делает отбой вызова;
//screenshots - делает скриншоты приложения или всего окна;
//uiDevice - средство для работы с экраном девайса: обнаружение элементов по локатору, выполнение с ними действий, физические кнопки,
// смена и проверка ориентации девайса, клик по координатам, свайп, получение размеров экрана и т.д.