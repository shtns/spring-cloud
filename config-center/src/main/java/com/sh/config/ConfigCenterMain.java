package com.sh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置中心主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/26 22:10
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigCenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain.class, args);
    }
}
