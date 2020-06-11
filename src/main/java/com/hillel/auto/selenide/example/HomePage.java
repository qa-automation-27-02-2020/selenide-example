package com.hillel.auto.selenide.example;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/10/20
 */
public class HomePage {

    static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    @Step("User should be logged in")
    public HomePage userShouldBeLoggedIn(String userName) {
        LOG.info("User should be logged in");
        $("[href='#@" +userName+"']").shouldBe(Condition.visible.because("User not logged in!"));
        return this;
    }

    public ArticlePage clickNewPostBtn() {

        return new ArticlePage();
    }
}
