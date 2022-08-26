package com.tinqin.estate.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@ComponentScan(basePackages = /*"com.example"*/{"com.tinqin.estate.rest",
        "com.tinqin.estate.api",
        "com.tinqin.estate.domain",
        "com.tinqin.estate.core"})
@EnableJpaRepositories(basePackages = "com.tinqin.estate.domain.data.repository")
@EntityScan(basePackages = "com.tinqin.estate.domain.data.entity")
@EnableSwagger2
@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
