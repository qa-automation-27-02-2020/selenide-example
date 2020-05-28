package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.Configuration;
import com.hillel.auto.selenide.example.HomePage;
import com.hillel.auto.selenide.example.LoginPage;
import com.hillel.auto.selenide.example.StartPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alpa on 5/28/20
 */
public class ArticleTest extends TestBase {

//    private StartPage startPage = new StartPage();
//    private LoginPage loginPage;


//    @BeforeMethod
//    public void setUp() {
//        open(Configuration.baseUrl);
//        loginPage = startPage.clickSignInBtn();
//        loginPage.login()
//    }

    @Test
    public void createArticleTest() {
        String userName = "realapp";
        String email = "realapp@mail.com";
        String password = "qwerty123";

        open(Configuration.baseUrl);
        StartPage startPage = new StartPage();
        LoginPage loginPage = startPage.clickSignInBtn();

        HomePage homePage = loginPage.login(email, password);
        homePage.userShouldBeLoggedIn(userName);

        homePage.clickNewPostBtn();
    }

}
