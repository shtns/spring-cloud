package com.sh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置客户端一主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/26 22:21
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientOneMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientOneMain.class, args);
    }
}
