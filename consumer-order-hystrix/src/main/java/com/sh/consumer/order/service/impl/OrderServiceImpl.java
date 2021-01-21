package com.sh.consumer.order.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.sh.api.common.constan.CommonConstants;
import com.sh.consumer.order.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

/**
 * 订单业务
 *
 *
 * @author 盛浩
 * @date 2020/12/26 20:50
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final PaymentService paymentHystrixService;

    @Value(value = "${server.port}")
    private String serverPort;

    /**
     * 正常访问
     *
     * @return 端口号
     */
    public String paymentInfOk() {
        return this.paymentHystrixService.paymentInfoOk();
    }

    /**
     * 超时访问，演示降级
     *
     * @return 端口号
     */
    public String paymentInfoTimeOut() {
        return this.paymentHystrixService.paymentInfoTimeOut();
    }

    /**
     * 降级兜底方案
     *
     * @return 端口号
     */
    public String timeOutHandler() {
        return "端口号：" + serverPort + "，" + CommonConstants.ForegroundPrompt.SERVER_BUSY_PLEASE_TRY_AGAIN_LATER;
    }

    /**
     * 服务熔断
     *
     * @param id 测试id
     * @return 流水号
     */
    public String paymentCircuitBreaker(Integer id) {
        if (StrUtil.isBlank(String.valueOf(id))) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.ForegroundPrompt.ID_CANNOT_BE_EMPTY);
        }
        if (CommonConstants.Digital.ZERO > id) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.ForegroundPrompt.ID_CANNOT_BE_NEGATIVE);
        }
        return "端口号：" + serverPort + "，调用成功，流水号：" + IdUtil.simpleUUID();
    }
}
