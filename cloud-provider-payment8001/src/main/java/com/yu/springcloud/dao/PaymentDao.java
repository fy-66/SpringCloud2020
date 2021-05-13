package com.yu.springcloud.dao;

import com.yu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *@descript 
 *@author yu
 *@date 2021/5/9 10:03
 *@version 1.0
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);
    /**
     * 查询
     * @author yu
     * @date 2021/5/9
     * @param id
     * @return com.yu.springcloud.entities.Payment
     */
    Payment getPaymentById(@Param("id") Long id);
}
