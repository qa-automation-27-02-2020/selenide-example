package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.hillel.auto.selenide.example.LoginPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

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

//    @Test
    public void validationTest() {
        $("[href='#register']").click();
        $("[type='submit']").click();
        ElementsCollection errorMessages = $$(".error-messages>li");
        errorMessages.shouldHave(CollectionCondition.texts("email can't be blank"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("83");
        capabilities.setPlatform(Platform.WIN10);

//        http://localhost:4444/wd/hub
        try {
            WebDriver driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}