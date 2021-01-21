package com.sh.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 消费hystrix仪表盘
 *
 *
 * @author 盛浩
 * @date 2020/12/26 21:12
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboardMain.class, args);
    }
}
