package com.wind.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@Import({ DispatcherServletAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class,
		ErrorMvcAutoConfiguration.class, HttpEncodingAutoConfiguration.class,
		HttpMessageConvertersAutoConfiguration.class, JacksonAutoConfiguration.class, MultipartAutoConfiguration.class,
		ServerPropertiesAutoConfiguration.class, WebMvcAutoConfiguration.class })
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.wind")
public class WindEurekaProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(WindEurekaProviderApplication.class, args);
	}
}
