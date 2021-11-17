package com.matrixboot.mall.order.infrastructure.repository;

import com.matrixboot.mall.common.value.OrderStatusEnum;
import com.matrixboot.mall.order.domain.entity.OrderMainEntity;
import org.springframework.stereotype.Component;

/**
 * 订单状态投影
 * <p>
 * create in 2021/11/17 2:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Component("OrderStatusProjection")
public class OrderStatusProjection {

    public OrderStatusEnum orderStatus(OrderMainEntity entity) {
        entity.orderNotExpired();
        return entity.getOrderStatus();
    }
}
