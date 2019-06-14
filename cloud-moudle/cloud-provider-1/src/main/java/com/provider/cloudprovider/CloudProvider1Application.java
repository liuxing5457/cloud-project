package com.provider.cloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider1Application.class, args);
    }

}
