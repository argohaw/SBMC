package com.sriram.catService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CatServiceApplication
{

    //Main method
    public static void main(String[] args)
    {
        SpringApplication.run(CatServiceApplication.class, args);
    }
}
