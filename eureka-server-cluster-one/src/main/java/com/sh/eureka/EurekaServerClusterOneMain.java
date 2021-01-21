package com.sh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心集群一主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/25 20:14
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerClusterOneMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerClusterOneMain.class, args);
    }
}
