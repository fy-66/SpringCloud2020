package com.yu.springcloud.service;

import com.yu.springcloud.entities.Payment;

/**
 *@descript 
 *@author yu
 *@date 2021/5/9 11:12
 *@version 1.0
 */
public interface PaymentService {

    /**
     * 插入数据
     * @author yu
     * @date 2021/5/9
     * @param payment
     * @return int
     */
    int create(Payment payment);
    /**
     * 根据id查询记录
     * @author yu
     * @date 2021/5/9
     * @param id
     * @return com.yu.springcloud.entities.Payment
     */
    Payment getPaymentById(Long id);
}
