package com.hillel.auto.selenide.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by alpa on 5/21/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@Builder
public class Author {

    @JsonProperty("username")
    private String username;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("image")
    private String image;
    @JsonProperty("following")
    private Boolean following;

    public static Author builder() {
        return new Author();
    }

    public Author bio(String bio) {
        this.bio = bio;
        return this;
    }

    public Author username(String username) {
        this.username = username;
        return this;
    }

    public Author following(boolean following) {
        this.following = following;
        return this;
    }

    public Author build() {
        return this;
    }
}
