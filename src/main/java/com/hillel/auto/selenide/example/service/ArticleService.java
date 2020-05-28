package com.hillel.auto.selenide.example.service;

import com.hillel.auto.selenide.example.model.Article;
import com.hillel.auto.selenide.example.model.ArticleResponse;
import io.restassured.RestAssured;

/**
 * Created by alpa on 5/21/20
 */
public class ArticleService extends ApiService  {

    private String token;

    public ArticleService(String token) {
        this.token = token;

    }

    public Article createArticle(Article article) {
        return RestAssured
                .given()
                .header("Authorization", "Token " + token)
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();
    }

    public void deleteArticle(String slug) {
        RestAssured
                .given()
                    .header("Authorization", "Token " + token)
                .when()
                    .delete("/articles/" + slug)
                .then()
                    .statusCode(200);
    }


}
