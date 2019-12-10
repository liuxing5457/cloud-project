package com.provider.cloudprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProvider1Application {

    private static Logger logger = LoggerFactory.getLogger(CloudProvider1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider1Application.class, args);
        logger.info("=============================cloud-provider-1系统启动成功==================================");
    }

}
