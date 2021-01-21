package com.sh.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 提供支付集群二主启动
 *
 *
 * @author 盛浩
 * @date 2020/12/26 16:48
 */
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProviderPaymentClusterTwoMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentClusterTwoMain.class, args);
    }
}
