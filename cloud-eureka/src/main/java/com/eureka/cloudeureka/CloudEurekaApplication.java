package com.eureka.cloudeureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaApplication {

    private static Logger logger = LoggerFactory.getLogger(CloudEurekaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
        logger.info("=============================cloud-eureka系统启动成功==================================");
    }

}
