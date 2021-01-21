package com.sh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * * 注册中心集群二主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/25 20:18
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerClusterTwoMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerClusterTwoMain.class, args);
    }
}
