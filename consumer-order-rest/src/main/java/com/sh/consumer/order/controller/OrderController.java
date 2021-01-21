package com.sh.consumer.order.controller;

import com.sh.api.common.util.R;
import com.sh.consumer.order.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理
 *
 *
 * @author 盛浩
 * @date 2020/12/25 22:02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/consumer/order_rest")
public class OrderController {

    private final OrderServiceImpl orderService;

    /**
     * 获取端口号（getForObject）
     *
     * @return 端口号
     */
    @GetMapping(value = "/get_for_object/server_port")
    public R<String> getForObjectServerPort() {
        return R.ok(this.orderService.getForObjectServerPort());
    }

    /**
     * 获取端口号（getForEntity）
     *
     * @return 端口号
     */
    @GetMapping(value = "/get_for_entity/server_port")
    public R<String> getForEntityServerPort() {
        return R.ok(this.orderService.getForEntityServerPort());
    }

    /**
     * 新增（postForObject）
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    @GetMapping(value = "/post_for_object/add/{str}")
    public R<String> postForObjectAdd(@PathVariable String str) {
        return R.ok(this.orderService.postForObjectAdd(str));
    }

    /**
     * 新增（postForEntity）
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    @GetMapping(value = "/post_for_entity/add/{str}")
    public R<String> postForEntityAdd(@PathVariable String str) {
        return R.ok(this.orderService.postForEntityAdd(str));
    }
}
