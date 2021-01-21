package com.sh.provider.payment.controller;

import com.sh.provider.payment.service.PaymentHystrixServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付hystrix管理
 *
 *
 * @author 盛浩
 * @date 2020/12/26 20:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/provider/payment_hystrix")
public class PaymentHystrixController {

    private final PaymentHystrixServiceImpl paymentHystrixService;

    /**
     * 正常访问
     *
     * @return 端口号
     */
    @GetMapping(value = "/ok")
    public String paymentInfoOk() {
        return this.paymentHystrixService.paymentInfoOk();
    }

    /**
     * 超时访问，演示降级
     *
     * @return 端口号
     */
    @GetMapping(value = "/time_out")
    public String paymentInfoTimeOut() {
        return this.paymentHystrixService.paymentInfoTimeOut();
    }
}
