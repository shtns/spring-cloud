package com.sh.consumer.order.service;

import com.sh.api.common.constan.CommonConstants;
import com.sh.consumer.order.service.impl.fallback.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 支付服务
 *
 *
 * @author 盛浩
 * @date 2020/12/26 20:45
 */
@FeignClient(value = CommonConstants.MicroServiceName.PROVIDER_PAYMENT_SERVICE_HYSTRIX_NAME,
        fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    /**
     * 正常访问
     *
     * @return 端口号
     */
    @GetMapping(value = "/provider/payment_hystrix/ok")
    String paymentInfoOk();

    /**
     * 超时访问，演示降级
     *
     * @return 端口号
     */
    @GetMapping(value = "/provider/payment_hystrix/time_out")
    String paymentInfoTimeOut();
}
