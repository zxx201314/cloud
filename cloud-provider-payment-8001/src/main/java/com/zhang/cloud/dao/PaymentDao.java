package com.zhang.cloud.dao;

import com.zhang.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int save(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
