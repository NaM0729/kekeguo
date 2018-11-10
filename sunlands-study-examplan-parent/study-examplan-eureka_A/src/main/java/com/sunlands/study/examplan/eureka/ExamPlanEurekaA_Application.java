package com.sunlands.study.examplan.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月08日10:32:50
 */
@EnableEurekaServer
@SpringBootApplication
public class ExamPlanEurekaA_Application {

	public static void main(String[] args) {
		SpringApplication.run(ExamPlanEurekaA_Application.class, args);
	}
}
