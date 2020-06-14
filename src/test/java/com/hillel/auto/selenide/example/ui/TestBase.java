package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

/**
 * Created by alpa on 5/24/20
 */
public class TestBase {

    static {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
        Configuration.screenshots = true;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }
}
