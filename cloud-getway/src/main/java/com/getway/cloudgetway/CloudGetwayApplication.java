package com.getway.cloudgetway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGetwayApplication {

    private static Logger logger = LoggerFactory.getLogger(CloudGetwayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudGetwayApplication.class, args);
        logger.info("=============================cloud-gateway系统启动成功==================================");
    }

}
