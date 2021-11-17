package com.matrixboot.mall.order.application;

import com.matrixboot.mall.common.value.OrderStatusEnum;
import com.matrixboot.mall.common.value.PaymentTypeEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * <p>
 * create in 2021/11/17 1:19 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderPayCallbackCommand {

    Long orderId;

    OrderStatusEnum orderStatus;

    PaymentTypeEnum paymentType;

    String message;
}
