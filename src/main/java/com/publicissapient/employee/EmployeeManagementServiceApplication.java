package com.publicissapient.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.publicissapient.employee.interceptor.AuthenticationInterceptor;

@SpringBootApplication
public class EmployeeManagementServiceApplication implements WebMvcConfigurer{

	@Autowired
	AuthenticationInterceptor authenticationInterceptor;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementServiceApplication.class, args);
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor
		(authenticationInterceptor).addPathPatterns("/employee**");
		System.out.println("appconfig");
	}
}
