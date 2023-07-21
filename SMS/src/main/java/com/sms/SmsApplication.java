package com.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sms.config.JwtFilter;

//@Configuration, @EnableAutoConfiguration , @ComponentScan
@SpringBootApplication
public class SmsApplication {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean register = new FilterRegistrationBean();
		register.setFilter(new JwtFilter());
		register.addUrlPatterns("/api/*");
		return register;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
		System.out.println("Studant management system is running...");
	}

}
