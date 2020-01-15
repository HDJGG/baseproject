package com.hdj.baseproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.hdj.baseproject"})
@ImportResource({"classpath*:spring/*.xml"})
public class BaseprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseprojectApplication.class, args);
    }

}
