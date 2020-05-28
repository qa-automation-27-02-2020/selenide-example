package com.hillel.auto.selenide.example;

import com.hillel.auto.selenide.example.config.UserConfig;
import com.hillel.auto.selenide.example.config.UserConfiguration;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

/**
 * Created by alpa on 5/28/20
 */
public class TestPropertiesExample {

    private UserConfiguration userConfiguration = ConfigFactory.create(UserConfiguration.class);

    @SneakyThrows
    @Test
    public void readUserPropertyTest()  {
        String userName = UserConfig.getInstance().userName();
        System.out.println(userName);
    }

    @Test
    public void readUserEmailPropertyTest()  {
        String userName = userConfiguration.email();
        System.out.println(userName);
    }

    @Test
    public void readDefaultUserPropertyTest()  {
        String userName = userConfiguration.name();
        System.out.println("readDefaultUserPropertyTest: " + userName);
    }

    @Test
    public void readUserRolePropertyTest()  {
        String userName = userConfiguration.role();
        System.out.println(userName);
    }
}
