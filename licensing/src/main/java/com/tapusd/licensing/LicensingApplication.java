package com.tapusd.licensing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class LicensingApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		// ribbon backed rest template will be created as bean from here
		// ribbon is netflix project for clie
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(LicensingApplication.class, args);
	}

}
