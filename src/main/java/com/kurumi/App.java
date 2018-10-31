package com.kurumi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.kurumi.datasource.DynamicDataSourceRegister;


/*
@EnableTransactionManagement*/		
@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) 
@MapperScan(basePackages="com.kurumi.mapper")
public class App extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	
}
