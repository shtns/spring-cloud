package com.sh.consumer.order.service;

import cn.hutool.core.util.StrUtil;
import com.sh.api.common.constan.CommonConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 订单业务
 *
 *
 * @author 盛浩
 * @date 2020/12/25 22:02
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final RestTemplate restTemplate;

    /**
     * 获取端口号（getForObject）
     *
     * @return 端口号
     */
    public String getForObjectServerPort() {
        return restTemplate.getForObject(CommonConstants.MicroCallingLocation.PAYMENT_CALL_URL + "server_port", String.class);
    }

    /**
     * 获取端口号（getForEntity）
     *
     * @return 端口号
     */
    public String getForEntityServerPort() {
        return restTemplate.getForEntity(CommonConstants.MicroCallingLocation.PAYMENT_CALL_URL + "server_port", String.class).getBody();
    }

    /**
     * 新增（postForObject）
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    public String postForObjectAdd(String str) {
        this.checkStr(str);
        return restTemplate.postForObject(CommonConstants.MicroCallingLocation.PAYMENT_CALL_URL, str, String.class);
    }

    /**
     * 新增（postForEntity）
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    public String postForEntityAdd(String str) {
        this.checkStr(str);
        return restTemplate.postForEntity(CommonConstants.MicroCallingLocation.PAYMENT_CALL_URL, str, String.class).getBody();
    }

    /**
     * 检查字符串是否为空
     *
     * @param str 字符串
     */
    private void checkStr(String str) {
        if (StrUtil.isBlank(str)) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.ForegroundPrompt.STR_CANNOT_BE_EMPTY);
        }
    }
}
