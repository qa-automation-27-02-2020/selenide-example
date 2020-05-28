package com.hillel.auto.selenide.example.api;

import com.hillel.auto.selenide.example.model.Author;
import org.testng.annotations.Test;

/**
 * Created by alpa on 5/28/20
 */
public class BuilderExample {

    @Test
    public void builderTest() {
        Author author = Author.builder()
                .bio("sfsfd")
                .username("ssfsdf")
                .build();
//        Author author = new Author();
//        author.setBio("sdsdf");
//        author.setUsername("sfsdfsdf");
        System.out.println(author);
    }
}
