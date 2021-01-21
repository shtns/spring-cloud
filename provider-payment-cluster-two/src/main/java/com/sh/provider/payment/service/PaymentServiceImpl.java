package com.sh.provider.payment.service;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.sh.api.common.constan.CommonConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

/**
 * 支付业务
 *
 *
 * @author 盛浩
 * @date 2020/12/25 21:23
 */
@Service
public class PaymentServiceImpl  {

    @Value(value = "${server.port}")
    private String serverPort;

    /**
     * 获取端口号
     *
     * @return 端口号
     */
    public String getServerPort() {
        return serverPort;
    }

    /**
     * 模拟新增，提供给rest80，RestTemplate调用
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    public String providerRestPost(String str) {
        if (StrUtil.isBlank(str)) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.ForegroundPrompt.STR_CANNOT_BE_EMPTY);
        }
        return serverPort + "：" + str+ "：" + UUID.randomUUID().toString();
    }

    /**
     * openFeign超时调用测试
     *
     * @return 端口号
     */
    public String feignTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "端口号：" + serverPort+ "，openFeign调用测试";
    }
}
