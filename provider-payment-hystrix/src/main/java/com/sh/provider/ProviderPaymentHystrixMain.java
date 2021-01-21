package com.sh.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 提供支付hystrix主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/26 20:32
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProviderPaymentHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentHystrixMain.class, args);
    }
}
