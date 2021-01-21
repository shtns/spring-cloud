package com.sh.consumer.order.service;

import com.sh.api.common.constan.CommonConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 支付服务
 *
 *
 * @author 盛浩
 * @date 2020/12/26 17:07
 */
@FeignClient(value = CommonConstants.MicroServiceName.PROVIDER_PAYMENT_SERVICE_ONE_NAME)
public interface PaymentService {

    /**
     * 获取端口号
     *
     * @return 端口号
     */
    @GetMapping(value = "/provider/payment/server_port")
    String getServerPort();

    /**
     * 模拟新增，提供给rest80、feign80调用
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    @PostMapping(value = "/provider/payment/")
    String providerRestPost(@RequestBody String str);

    /**
     * openFeign超时调用测试
     *
     * @return 端口号
     */
    @GetMapping(value = "/provider/payment/feign_time_out")
    String feignTimeOut();
}
