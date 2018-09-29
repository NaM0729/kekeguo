package com.sportsxdata.adms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.sportsxdata.adms.dao")
public class AdmsApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AdmsApplication.class, args);
	}
}
