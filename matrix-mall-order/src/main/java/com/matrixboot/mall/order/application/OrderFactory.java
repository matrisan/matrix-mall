package com.matrixboot.mall.order.application;

import com.matrixboot.mall.common.value.OrderStatusEnum;
import com.matrixboot.mall.order.domain.entity.OrderDetailEntity;
import com.matrixboot.mall.order.domain.entity.OrderMainEntity;
import com.matrixboot.mall.order.domain.service.IOrderSerialService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO
 * <p>
 * create in 2021/11/16 11:40 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrderFactory {

    public static OrderMainEntity from(OrderMainCreateCommand command, IOrderSerialService service) {
        return OrderMainEntity.builder()
                .userId(command.getUserId())
                .orderSerial(service.generateOrderSerial())
                .businessId(command.getBusinessId())
                .mobile(command.getMobile())
                .orderStatus(OrderStatusEnum.ORDER_UNPAID)
                .paymentType(null)
                .orderDetails(detailCreateCommands(command.getOrderDetails()))
                .build();
    }

    private static List<OrderDetailEntity> detailCreateCommands(List<OrderDetailCreateCommand> orderDetails) {
        return orderDetails.stream().map(orderDetailCreateCommand -> OrderDetailEntity.builder()
                .skuId(orderDetailCreateCommand.getSkuId())
                .skuName(orderDetailCreateCommand.getSkuName())
                .build()).collect(Collectors.toList());
    }

}
