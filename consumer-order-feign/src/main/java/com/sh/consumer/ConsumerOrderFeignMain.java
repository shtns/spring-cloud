package com.sh.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 消费订单feign主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/26 17:03
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerOrderFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignMain.class, args);
    }
}
