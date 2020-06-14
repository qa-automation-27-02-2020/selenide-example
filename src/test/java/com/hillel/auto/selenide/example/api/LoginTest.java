package com.hillel.auto.selenide.example.api;

import com.hillel.auto.selenide.example.model.User;
import com.hillel.auto.selenide.example.utils.UserData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by alpa on 5/17/20
 */
public class LoginTest {

    private User user = UserData.defaultUser();

    @Test
    public void loginTest() {

        RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n"+
                        "\"user\": {\n"+
                        "\"email\": \""+user.getEmail()+"\",\n"+
                        "\"password\": \""+user.getPassword()+"\"\n"+
                        "}\n"+"}")
                .when()
                .post("https://conduit.productionready.io/api/users/login")
                .then()
                .statusCode(200)
                .body("user.email", equalTo(user.getEmail().toLowerCase()))
                .body("user.username", equalTo(user.getUsername()))
                .body("user.token", notNullValue())
                .log().all();
    }

}
