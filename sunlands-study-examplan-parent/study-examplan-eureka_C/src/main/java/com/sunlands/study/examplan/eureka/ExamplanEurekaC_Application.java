package com.sunlands.study.examplan.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ExamplanEurekaC_Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamplanEurekaC_Application.class, args);
    }
}
