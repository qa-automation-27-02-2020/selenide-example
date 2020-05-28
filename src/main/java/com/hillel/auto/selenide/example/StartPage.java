package com.hillel.auto.selenide.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/28/20
 */
public class StartPage {

    public By signIn = byAttribute("href", "#login");

    public LoginPage clickSignInBtn() {
        $(signIn).shouldBe(Condition.visible).click();
        return new LoginPage();
    }

}
