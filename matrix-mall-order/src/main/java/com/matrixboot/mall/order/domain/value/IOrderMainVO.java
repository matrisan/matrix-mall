package com.matrixboot.mall.order.domain.value;

import com.matrixboot.mall.common.value.OrderStatusEnum;
import com.matrixboot.mall.common.value.PaymentTypeEnum;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * <p>
 * create in 2021/11/16 11:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IOrderMainVO {

    Long getId();

    Long getUserId();

    /**
     * 订单状态
     *
     * @return OrderStatusEnum
     */
    @Value("#{@OrderStatusProjection.orderStatus(target)}")
    OrderStatusEnum getOrderStatus();

    PaymentTypeEnum getPaymentType();

    Integer getPrice();

    List<IOrderDetailVO> getOrderDetails();

}
