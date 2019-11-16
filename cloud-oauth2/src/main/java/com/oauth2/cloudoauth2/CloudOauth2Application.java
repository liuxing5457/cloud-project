package com.oauth2.cloudoauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName CloudOauth2Application
 * @Description TODO
 * @Author  xuzibang
 * @Date 2019/11/16
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudOauth2Application {

    private static Logger logger = LoggerFactory.getLogger(CloudOauth2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudOauth2Application.class, args);
        logger.info("============ Oauth2 系统启动成功 ===========");
    }

}
