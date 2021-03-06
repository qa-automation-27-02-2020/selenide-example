package com.hillel.auto.selenide.example;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/10/20
 */
public class LoginPage {

    static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

    private By authForm = byCssSelector(".auth-page");
    private By loginLink = byAttribute("href", "#login");
    private By emailField = byCssSelector("input[type='email']");
    private By passwordField = byCssSelector("input[type='password']");
    private By signInBtn = byCssSelector("button[type='submit']");

    private By loginInAuthForm = new ByChained(authForm, emailField);

    @Step("Open Login page")
    public LoginPage openPage() {
        LOG.info("Open Login page");
        $(loginLink).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Login as user")
    public HomePage login(String email, String password) {
        LOG.info("Login as user");
        inputEmail(email);
        inputPassword(password);
        return clickSingInButton();
    }

    @Step
    public void inputEmail(String email) {
        LOG.info("Input email");
//        $(authForm).$(emailField).setValue(email);
        $(loginInAuthForm).setValue(email);
    }

    @Step
    public void inputPassword(String password) {
        LOG.info("Input password");
        LOG.debug("Input password {}", password);
       $(passwordField).setValue(password);
    }

    public String getPageTitle() {
       return $(".auth-page h1").text();
    }

    @Step("Click Sing In button")
    public HomePage clickSingInButton() {
        LOG.info("Click Sing In button");
        $(signInBtn).click();
        return new HomePage();
    }

}
