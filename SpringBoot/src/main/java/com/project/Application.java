package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 扫描mapper.xml对应的dao接口
 * */
@MapperScan("com.**.**.dao")
@SpringBootApplication
//@EnableAutoConfiguration(exclude={
//		JpaRepositoriesAutoConfiguration.class//禁止springboot自动加载持久化bean
//})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
