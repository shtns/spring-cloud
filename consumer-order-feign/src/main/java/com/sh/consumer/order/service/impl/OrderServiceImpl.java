package com.sh.consumer.order.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sh.api.common.constan.CommonConstants;
import com.sh.consumer.order.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpServerErrorException;

/**
 * 订单业务
 *
 *
 * @author 盛浩
 * @date 2020/12/26 17:09
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final PaymentService paymentFeignService;

    /**
     * 获取端口号
     *
     * @return 端口号
     */
    @GetMapping(value = "/server_port")
    public String getServerPort() {
        return this.paymentFeignService.getServerPort();
    }

    /**
     * 新增
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    public String add(String str) {
        if (StrUtil.isBlank(str)) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.ForegroundPrompt.STR_CANNOT_BE_EMPTY);
        }
        return this.paymentFeignService.providerRestPost(str);
    }

    /**
     * openFeign超时调用测试
     *
     * @return 端口号
     */
    @GetMapping(value = "/time_out")
    public String feignTimeOut() {
        return this.paymentFeignService.feignTimeOut();
    }
}
