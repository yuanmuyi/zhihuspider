package com.yy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yy.dao.mapper")
public class ZhihuspiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhihuspiderApplication.class, args);
	}
}
