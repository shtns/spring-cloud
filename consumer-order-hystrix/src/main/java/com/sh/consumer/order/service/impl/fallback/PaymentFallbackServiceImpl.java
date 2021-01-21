package com.sh.consumer.order.service.impl.fallback;

import com.sh.api.common.constan.CommonConstants;
import com.sh.consumer.order.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * 当被调用服务宕机时返回的默认值
 *
 *
 * @author 盛浩
 * @date 2020/12/26 20:47
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOk() {
        return CommonConstants.ForegroundPrompt.SERVER_BUSY_PLEASE_TRY_AGAIN_LATER;
    }

    @Override
    public String paymentInfoTimeOut() {
        return CommonConstants.ForegroundPrompt.SERVER_BUSY_PLEASE_TRY_AGAIN_LATER;
    }
}
