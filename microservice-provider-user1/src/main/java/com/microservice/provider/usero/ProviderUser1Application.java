package com.microservice.provider.usero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderUser1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUser1Application.class, args);
    }

}
