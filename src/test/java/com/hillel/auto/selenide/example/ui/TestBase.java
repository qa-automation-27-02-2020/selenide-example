package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.Configuration;

/**
 * Created by alpa on 5/24/20
 */
public class TestBase {

    static {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
        Configuration.screenshots = false;
    }
}
