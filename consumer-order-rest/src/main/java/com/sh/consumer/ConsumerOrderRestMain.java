package com.sh.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费订单rest主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/25 21:59
 */
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerOrderRestMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderRestMain.class, args);
    }
}
