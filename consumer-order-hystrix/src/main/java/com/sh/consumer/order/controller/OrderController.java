package com.sh.consumer.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sh.api.common.util.R;
import com.sh.consumer.order.service.impl.OrderServiceImpl;
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
 * @date 2020/12/26 20:44
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/consumer/order_hystrix")
@DefaultProperties(defaultFallback = "globalTimeOutHandler")
public class OrderController {

    //@HystrixCommand(fallbackMethod = "timeOutHandler")自定义兜底方案

    private final OrderServiceImpl orderHystrixService;

    /**
     * 正常访问
     *
     * @return 端口号
     */
    @GetMapping(value = "/ok")
    public R<String> paymentInfOk() {
        return R.ok(this.orderHystrixService.paymentInfOk());
    }

    /**
     * 超时访问，演示降级
     *
     * @return 端口号
     */
    @GetMapping(value = "/time_out")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") //超时、运行异常都会使用兜底方案
    })
    public R<String> paymentInfoTimeOut() {
        return R.ok(this.orderHystrixService.paymentInfoTimeOut());
    }

    /**
     * 全局降级兜底处理
     *
     * @return 端口号
     */
    public R<String> globalTimeOutHandler() {
        return R.ok(this.orderHystrixService.timeOutHandler());
    }

    /**
     * 服务熔断（降级、跳闸、恢复调用链路）
     *
     * @param id 测试id
     * @return 唯一流水号
     */
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启断路器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //在10秒窗口期内
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求数达到10次后计算
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //错误率达到百分比60触发熔断
    })
    @GetMapping(value = "/circuit_breaker/{id}")
    public R<String> paymentCircuitBreaker(@PathVariable Integer id) {
        return R.ok(this.orderHystrixService.paymentCircuitBreaker(id));
    }

    /**
     * 服务熔断兜底方案
     *
     * @return 流水号
     */
    private R<String> circuitBreakerFallback(Integer id) {
        return R.ok("id：" + id + "不能为负数，请重新输入");
    }
}
