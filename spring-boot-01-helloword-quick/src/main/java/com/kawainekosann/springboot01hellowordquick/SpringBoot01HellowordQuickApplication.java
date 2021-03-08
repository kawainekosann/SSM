package com.kawainekosann.springboot01hellowordquick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBoot01HellowordQuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01HellowordQuickApplication.class, args);
    }

}
