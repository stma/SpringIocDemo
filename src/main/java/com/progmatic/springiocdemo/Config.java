package com.progmatic.springiocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
public class Config {

    private Environment env;

    @Autowired
    public Config(Environment env) {
        this.env = env;
    }

    @Bean("inner")
    public Impl getInnerService() {
        return new ImplC1();
    }

    @Bean("publikus")
//    @Primary
    public Impl getPublicService() {
        return new ImplC2();
    }

//    @Bean
//    public Impl getService() {
//        String e = env.getProperty("app.env", "nope");
//        return switch (e) {
//            case "p" -> new ImplC1();
//            default -> new ImplC2();
//        };
//    }
}
