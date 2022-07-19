package com.zhang.cloud.service.fallback;

import com.zhang.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/19 20:50
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fallback paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService fallback paymentInfo_Timeout";
    }
}
