package com.hillel.auto.selenide.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends TestBase {

    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
    }

    @Test
    public void openPage() {
//        Configuration.browser = "firefox";
//        Configuration.headless = true;
//        Configuration.baseUrl = "https://react-redux.realworld.io/";
//        WebElement signUpButton = driver.findElement(By.cssSelector("a[href='#login']"));
//        signUpButton.click();
//        $ = driver.findElement
//        SelenideElement selenideElement = $("a[href='#login']");
//        selenideElement.shouldBe(Condition.visible);
//        selenideElement.click();
//        $("a[href='#login']").shouldBe(Condition.visible).click();
//        $x("//a[@href='#login']").shouldBe(Condition.visible).click();
//        $(By.cssSelector("a[href='#login']")).shouldBe(Condition.visible).click();
//        $(byCssSelector("a[href='#login']")).shouldBe(Condition.visible).click();
//        $(by("href", "#login")).shouldBe(Condition.visible).click();
        $(byAttribute("href", "#login")).shouldBe(Condition.visible).click();
    }

    @Test
    public void loginTest() {
        String userName = "realapp";
        String email = "realapp@mail.com";
        String password = "qwerty123";

        loginPage
                .openPage()
                .login(email, password)
                .userShouldBeLoggedIn(userName);
    }
}