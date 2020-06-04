package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;

import java.util.logging.Level;

/**
 * Created by alpa on 5/24/20
 */
public class TestBase {

    static {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
//        Configuration.screenshots = false;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true)
                        .savePageSource(true)
                        .enableLogs(LogType.BROWSER, Level.INFO));
    }
}
