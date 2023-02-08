package com.progmatic.springiocdemo;

import org.springframework.stereotype.Component;

@Component
public interface Impl {

    default public String name() {
        return this.getClass().toString();
    }
}
