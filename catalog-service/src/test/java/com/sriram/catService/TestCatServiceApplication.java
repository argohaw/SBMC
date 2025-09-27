package com.sriram.catService;

import org.springframework.boot.SpringApplication;

public class TestCatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(CatServiceApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}
