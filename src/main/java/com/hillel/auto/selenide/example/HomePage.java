package com.hillel.auto.selenide.example;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/10/20
 */
public class HomePage {

    @Step("User should be logged in")
    public HomePage userShouldBeLoggedIn(String userName) {
        $("[href='#@" +userName+"']").shouldBe(Condition.visible.because("User not logged in!"));
        return this;
    }

    public ArticlePage clickNewPostBtn() {

        return new ArticlePage();
    }
}
