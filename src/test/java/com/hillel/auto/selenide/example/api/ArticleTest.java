package com.hillel.auto.selenide.example.api;

import com.hillel.auto.selenide.example.model.Article;
import com.hillel.auto.selenide.example.model.ArticleResponse;
import com.hillel.auto.selenide.example.model.User;
import com.hillel.auto.selenide.example.service.UserService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by alpa on 5/21/20
 */
public class ArticleTest {

    private UserService userService = new UserService();
    private User user;

    @BeforeClass
    public void setUp() {
        user = userService.userRegistration();
        RestAssured.baseURI = "https://conduit.productionready.io";
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setAccept(ContentType.JSON)
                        .setContentType(ContentType.JSON)
                        .addHeader("Authorization", "Token " + user.getToken())
                        .log(LogDetail.ALL)
                        .build();
    }

    @Test
    public void createArticle() {
        Article article = new Article();
        article.setTitle("First article");
        article.setDescription("Super Article desc");
        article.setBody("test hoho");
        article.setTagList(Arrays.asList("test", "hoho"));

        Article newArticle = RestAssured
                .given()
                    .body(article)
                .when()
                    .post("/articles")
                .then()
                    .statusCode(200)
                    .extract().body()
                .as(ArticleResponse.class)
                .getArticle();

        System.out.println(newArticle);

    }

}
