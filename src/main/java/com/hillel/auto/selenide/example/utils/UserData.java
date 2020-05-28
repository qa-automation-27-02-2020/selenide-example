package com.hillel.auto.selenide.example.utils;

import com.github.javafaker.Faker;
import com.hillel.auto.selenide.example.model.User;

/**
 * Created by alpa on 5/7/20
 */
public class UserData {

    public static User defaultUser() {
        return new User("realapp", "realapp@mail.com", "qwerty123");
    }

    public static User randomUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUsername(faker.name().username());
        user.setEmail(faker.name().lastName() + "@mail.com");
        user.setPassword("qwerty123");
        return user;
    }
}
