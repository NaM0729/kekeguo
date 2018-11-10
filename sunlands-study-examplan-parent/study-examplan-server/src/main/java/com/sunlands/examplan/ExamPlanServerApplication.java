package com.sunlands.examplan;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import java.io.IOException;

/**
 * 学习计划服务类
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月08日10:32:17
 */
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.sunlands.examplan.mapper"})
public class ExamPlanServerApplication {


    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamPlanServerApplication.class);


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        try {
            SpringApplication application = new SpringApplication(ExamPlanServerApplication.class);
            application.setRegisterShutdownHook(false);
            application.setBannerMode(Banner.Mode.CONSOLE);
            application.run(args);
            LOGGER.info("ExamPlanServerApplication started!!!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
