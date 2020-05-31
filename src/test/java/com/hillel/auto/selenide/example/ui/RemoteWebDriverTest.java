package com.hillel.auto.selenide.example.ui;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.hillel.auto.selenide.example.config.BrowserConfiguration;
import com.hillel.auto.selenide.example.config.UserConfiguration;
import com.hillel.auto.selenide.example.providers.ChromeWebDriverProvider;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alpa on 5/31/20
 */
public class RemoteWebDriverTest {

    private BrowserConfiguration browserConfiguration = ConfigFactory.create(BrowserConfiguration.class);


//    @SneakyThrows
//    @Test
//    public void signInValidationTest() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("83.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
//
//        WebDriver driver = null;
//        try {
//            driver = new RemoteWebDriver(
//                    URI.create("http://localhost:4444/wd/hub").toURL(),
//                    capabilities
//            );
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        driver.get("https://react-redux.realworld.io/");
//        Thread.sleep(10_000);
//        driver.findElement(By.cssSelector("[href='#register']")).click();
//        Thread.sleep(10_000);
//        driver.findElement(By.cssSelector("[type='submit']")).click();
//        Thread.sleep(10_000);
//        int errorMessagesSize = driver.findElements(By.cssSelector(".error-messages>li")).size();
//        System.out.println("errorMessagesSize: " + errorMessagesSize);
//
//        driver.quit();
//    }

//    @SneakyThrows
//    @Test
//    public void signInValidationTest() {
//        Configuration.baseUrl = "https://react-redux.realworld.io/";
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.browser = "chrome";
//        DesiredCapabilities chrome = DesiredCapabilities.chrome();
//        chrome.setCapability("enableVNC", true);
//        chrome.setCapability("enableVideo", false);
//        Configuration.browserCapabilities = chrome;
//
//        open(Configuration.baseUrl);
//
//        $("[href='#register']").click();
//        $("[type='submit']").click();
//        ElementsCollection errorMessages = $$(".error-messages>li");
//        errorMessages.shouldHaveSize(3);
//    }

    @SneakyThrows
    @Test
    public void signInValidationTest() {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
        Configuration.browser = browserConfiguration.remoteChrome();
//        Configuration.browser = ChromeWebDriverProvider.class.getName();
//        Configuration.browser = "com.hillel.auto.selenide.example.providers.ChromeWebDriverProvider";

        open(Configuration.baseUrl);

        $("[href='#register']").click();
        $("[type='submit']").click();
        ElementsCollection errorMessages = $$(".error-messages>li");
        errorMessages.shouldHaveSize(3);
    }
}
