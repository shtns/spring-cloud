package com.sh.consumer.order.controller;

import com.sh.api.common.util.R;
import com.sh.consumer.order.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 订单f管理
 *
 *
 * @author 盛浩
 * @date 2020/12/26 17:06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/consumer/order_feign")
public class OrderController {

    private final OrderServiceImpl orderFeignService;

    /**
     * 获取端口号
     *
     * @return 端口号
     */
    @GetMapping(value = "/server_port")
    public R<String> getServerPort() {
        return R.ok(this.orderFeignService.getServerPort());
    }

    /**
     * 新增
     *
     * @param str 字符串
     * @return 端口号+字符串+唯一id
     */
    @PostMapping
    public R<String> add(@RequestBody String str) {
        return R.ok(this.orderFeignService.add(str));
    }

    /**
     * openFeign超时调用测试
     *
     * @return 端口号
     */
    @GetMapping(value = "/time_out")
    public R<String> feignTimeOut() {
        return R.ok(this.orderFeignService.feignTimeOut());
    }
}
