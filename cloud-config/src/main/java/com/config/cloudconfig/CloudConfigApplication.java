package com.config.cloudconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/**开启配置中心自动配置*/
@EnableConfigServer
/**开启注册中心自动配置*/
@EnableEurekaClient
public class CloudConfigApplication {

    private static Logger logger = LoggerFactory.getLogger(CloudConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class, args);
        logger.info("============ cloud-config系统启动成功 ===========");
    }

}
