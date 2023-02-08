package com.progmatic.springiocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Emez {

    private final Scanner sc;
    private final Impl impl;
    private Az az1;

    @Autowired
    private Az az2;

    @Autowired
    private Sok s1;
    @Autowired
    private Sok s2;
    @Autowired
    private Sok s3;
    @Autowired
    private Sok s4;

    @Autowired
//    @Qualifier("inner")
    private Impl inner;
    @Autowired
//    @Qualifier("publikus")
    private Impl publikus;

    private String appName;


    public Emez(Az az1, Impl publikus) {
        sc = new Scanner(System.in);
        this.az1 = az1;
        this.impl = publikus;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void mainMenu() {
        try (sc) {
            System.out.println("*".repeat(30));
            System.out.println("*   Spring IoC Demo");
            System.out.println("*".repeat(30) + "\n");

            String s;
            this.printMenu();
            while (!(s = sc.nextLine()).equalsIgnoreCase("k")) {
                switch (s.toLowerCase()) {
                    case "s" -> singletonDemo();
                    case "v" -> printAppName();
                    case "c" -> configurationClassInjection();
                    case "p" -> usePrototypeBeans();
                    case "q" -> showQualifier();
                    default -> System.out.println("Ilyen menuelem nincs, kerem valasszon ujra.\n");
                }
                this.printMenu();
            }
        }
    }

    private void showQualifier() {
        System.out.println(inner);
        System.out.println(publikus);
    }

    private void usePrototypeBeans() {
        for (var i: List.of(s1, s2, s3, s4)) {
            System.out.println(i);
        }
    }

    private void configurationClassInjection() {
        System.out.println(this.impl.name());
    }

    @Autowired
    private void injectValue(@Value("${app.name}") String name) {
        this.appName = name;
    }

    private void printAppName() {
        System.out.println(appName);
    }

    private void singletonDemo() {
        System.out.println(az2.name);
        az2.name = "Kacsika";
        System.out.println(az2.name);
        System.out.println(az1.name);
    }

    private void printMenu() {
        System.out.println("s - Singleton");
        System.out.println("v - Value");
        System.out.println("p - Prototype");
        System.out.println("c - Configuration");
        System.out.println("q - Qualifier");

        System.out.println("------------------");

        System.out.println("k - Kilepes");
    }
}
