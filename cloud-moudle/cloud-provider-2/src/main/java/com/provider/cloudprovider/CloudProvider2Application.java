package com.provider.cloudprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class CloudProvider2Application {

    private static Logger logger = LoggerFactory.getLogger(CloudProvider2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider2Application.class, args);
        logger.info("=============================cloud-provider-2系统启动成功==================================");
    }

}
