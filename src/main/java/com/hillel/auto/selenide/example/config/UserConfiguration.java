package com.hillel.auto.selenide.example.config;

import org.aeonbits.owner.Config;

/**
 * Created by alpa on 5/28/20
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:test.properties",
        "system:properties",
        "system:env"})
public interface UserConfiguration extends Config {

    @DefaultValue("default_Name")
    @Key("user.name")
    String name();
    @Key("user.email")
    String email();
    @Key("user.password")
    String password();
    @DefaultValue("ADMIN")
    @Key("user.role")
    String role();
}
