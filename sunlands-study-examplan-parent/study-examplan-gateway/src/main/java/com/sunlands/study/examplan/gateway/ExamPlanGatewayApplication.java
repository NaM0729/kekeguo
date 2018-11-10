package com.sunlands.study.examplan.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * 网关中心
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月08日10:32:24
 */
@EnableHystrix
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ExamPlanGatewayApplication {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamPlanGatewayApplication.class);


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        try {
            SpringApplication application = new SpringApplication(ExamPlanGatewayApplication.class);
            application.setRegisterShutdownHook(false);
            application.setBannerMode(Banner.Mode.CONSOLE);
            application.run(args);
            LOGGER.info("ExamPlanGatewayApplication started!!!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }


}
