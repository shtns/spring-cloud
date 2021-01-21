package com.sh.provider.payment.controller;

import com.sh.provider.payment.service.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 支付管理（提供rest80、feign80调用）
 *
 *
 * @author 盛浩
 * @date 2020/12/25 21:36
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/provider/payment")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    /**
     * 获取端口号
     *
     * @return 端口号
     */
    @GetMapping(value = "/server_port")
    public String getServerPort() {
        return this.paymentService.getServerPort();
    }

    /**
     * 模拟新增，提供给rest80、feign80调用
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    @PostMapping
    public String providerRestPost(@RequestBody String str) {
        return this.paymentService.providerRestPost(str);
    }

    /**
     * openFeign超时调用测试
     *
     * @return 端口号
     */
    @GetMapping(value = "/feign_time_out")
    public String feignTimeOut() {
        return this.paymentService.feignTimeOut();
    }
}
