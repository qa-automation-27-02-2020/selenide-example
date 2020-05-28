package com.hillel.auto.selenide.example.service;

import com.hillel.auto.selenide.example.model.User;
import com.hillel.auto.selenide.example.model.UserResponse;
import com.hillel.auto.selenide.example.utils.UserData;
import io.restassured.RestAssured;

/**
 * Created by alpa on 5/21/20
 */
public class UserService extends ApiService {

    public User userRegistration() {
        User user = UserData.randomUser();
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);

        User newUser = RestAssured
                .given()
                .body(userResponse)
                .when()
                .post("/users")
                .then()
                .statusCode(200)
                .extract().body()
                .as(UserResponse.class)
                .getUser();

        newUser.setPassword(user.getPassword());
        return newUser;
    }

}
