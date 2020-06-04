package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.hillel.auto.selenide.example.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Authorization feature")
@Story("Login story")
public class ParallelTest extends TestBase {

    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
    }

    @Test
    public void openPage() {
        loginPage.openPage();
        $(byAttribute("href", "#loginesdf"))
                .shouldBe(Condition.visible).click();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("TMS-1122")
    public void loginTest() {
        String userName = "realapp";
        String email = "realapp@mail.com";
        String password = "qwerty123";

        loginPage
                .openPage()
                .login(email, password)
                .userShouldBeLoggedIn(userName);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("TMS-221")
    public void logoutTest() {
        String userName = "realapp";
        String email = "realapp@mail.com";
        String password = "qwerty123";

        loginPage
                .openPage()
                .login(email, password)
                .userShouldBeLoggedIn(userName);
    }

}