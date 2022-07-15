package com.zhang.cloud.service;

import com.zhang.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
