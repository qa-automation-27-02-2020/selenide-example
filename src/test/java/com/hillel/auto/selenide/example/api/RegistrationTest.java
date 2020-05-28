package com.hillel.auto.selenide.example.api;

import com.hillel.auto.selenide.example.model.User;
import com.hillel.auto.selenide.example.model.UserResponse;
import com.hillel.auto.selenide.example.utils.UserData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 5/17/20
 */
public class RegistrationTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://conduit.productionready.io";
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setAccept(ContentType.JSON)
                        .setContentType(ContentType.JSON)
                        .log(LogDetail.ALL)
                        .build();
    }



    @Test
    public void registrationUserTest() {
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

        assertThat(newUser.getEmail()).isEqualToIgnoringCase(user.getEmail());
        assertThat(newUser.getUsername()).isEqualToIgnoringCase(user.getUsername());
    }
}
