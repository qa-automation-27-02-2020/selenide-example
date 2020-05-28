package com.hillel.auto.selenide.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/10/20
 */
public class LoginPage {

    private By authForm = byCssSelector(".auth-page");
    private By loginLink = byAttribute("href", "#login");
    private By emailField = byCssSelector("input[type='email']");
    private By passwordField = byCssSelector("input[type='password']");
    private By signInBtn = byCssSelector("button[type='submit']");

    private By loginInAuthForm = new ByChained(authForm, emailField);

    public LoginPage openPage() {
        $(loginLink).shouldBe(Condition.visible).click();
        return this;
    }

    public HomePage login(String email, String password) {
        System.out.println("Login as user");
        inputEmail(email);
        inputPassword(password);
        return clickSingInButton();
    }

    public void inputEmail(String email) {
        System.out.println("Input email");
//        $(authForm).$(emailField).setValue(email);
        $(loginInAuthForm).setValue(email);
    }

    public void inputPassword(String password) {
        System.out.println("Input password");
       $(passwordField).setValue(password);
    }

    public String getPageTitle() {
       return $(".auth-page h1").text();
    }

    public HomePage clickSingInButton() {
        System.out.println("Click Sing In button");
        $(signInBtn).click();
        return new HomePage();
    }


}
