package com.sh.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 提供支付集群一主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/25 21:06
 */
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProviderPaymentClusterOneMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentClusterOneMain.class, args);
    }
}
