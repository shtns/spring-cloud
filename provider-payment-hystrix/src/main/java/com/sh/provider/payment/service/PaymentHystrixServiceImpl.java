package com.sh.provider.payment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 支付hystrix业务
 *
 *
 * @author 盛浩
 * @date 2020/12/26 20:34
 */
@Service
public class PaymentHystrixServiceImpl {

    @Value(value = "${server.port}")
    private String serverPort;

    /**
     * 正常访问
     *
     * @return 端口号
     */
    public String paymentInfoOk() {
        return "端口号：" + serverPort;
    }

    /**
     * 超时访问，演示降级
     *
     * @return 端口号
     */
    public String paymentInfoTimeOut() {

        int timeSeconds = 3000;

        try {
            Thread.sleep(timeSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "端口号：" + serverPort +  "，耗时：" + timeSeconds + "ms";
    }
}
