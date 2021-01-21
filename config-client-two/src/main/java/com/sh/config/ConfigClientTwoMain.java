package com.sh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置客户端二主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/26 22:25
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientTwoMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientTwoMain.class, args);
    }
}
