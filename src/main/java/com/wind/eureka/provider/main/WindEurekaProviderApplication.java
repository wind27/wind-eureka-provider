package com.wind.eureka.provider.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.wind.eureka.provider.controller")
public class WindEurekaProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(WindEurekaProviderApplication.class, args);
	}
}
