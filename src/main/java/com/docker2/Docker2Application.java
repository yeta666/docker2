package com.docker2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描Mybatis mapper包路径
@MapperScan(basePackages = "com.docker2.mapper")
public class Docker2Application {

	public static void main(String[] args) {
		SpringApplication.run(Docker2Application.class, args);
	}
}
