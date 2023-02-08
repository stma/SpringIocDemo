package com.progmatic.springiocdemo;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
// singleton
// prototype
// request
// session
// application
// websocket
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Sok {
    static int counter = 0;

    int id;

    public Sok() {
        id = Sok.counter++;
    }

    @Override
    public String toString() {
        return "Sok - id=" + id;
    }
}
