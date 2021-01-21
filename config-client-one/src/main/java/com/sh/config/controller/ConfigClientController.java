package com.sh.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置客户端管理
 *
 *
 * @author 盛浩
 * @date 2020/12/26 22:23
 */
@RefreshScope
@RestController
@RequestMapping(value = "/config_client")
public class ConfigClientController {

    @Value(value = "${config.info}")
    private String configInfo;

    @GetMapping
    public String getConfigInfo() {
        return configInfo;
    }
}
