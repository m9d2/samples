package com.sample.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sample.shiro.infrastructure.mapper")
public class SampleSpringBootShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootShiroApplication.class, args);
	}

}

