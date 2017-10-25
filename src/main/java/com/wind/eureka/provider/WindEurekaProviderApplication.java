package com.wind.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient

@SpringBootApplication(scanBasePackages = "com.wind")
public class WindEurekaProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(WindEurekaProviderApplication.class, args);
	}
}
