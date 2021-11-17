package com.matrixboot.mall.order.domain.service;

/**
 * 订单序列号生成的基类
 * <p>
 * create in 2021/11/17 12:08 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IOrderSerialService {

    /**
     * 生成订单的序列号
     *
     * @return 订单的序列号
     */
    String generateOrderSerial();

}
