package com.matrixboot.mall.order.application.service;

import com.matrixboot.mall.order.application.OrderMainCreateCommand;
import com.matrixboot.mall.order.application.OrderFactory;
import com.matrixboot.mall.order.application.OrderPayCallbackCommand;
import com.matrixboot.mall.order.application.OrderUpdateCommand;
import com.matrixboot.mall.order.domain.entity.OrderMainEntity;
import com.matrixboot.mall.order.domain.repository.IOrderMainEntityRepository;
import com.matrixboot.mall.order.domain.service.IOrderSerialService;
import com.matrixboot.mall.order.domain.value.IOrderMainVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * <p>
 * create in 2021/11/16 11:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
@AllArgsConstructor
public class MatrixOrderService {

    private final IOrderMainEntityRepository repository;

    @Transactional(rollbackFor = Exception.class)
    @Nullable
    public OrderMainEntity findOrderByOrderId(long orderId) {
        Optional<OrderMainEntity> optional = repository.findById(orderId);
        optional.ifPresent(OrderMainEntity::orderNotExpired);
        OrderMainEntity entity = optional.orElse(null);
        log.info("根据订单的 ID 查询订单:{}", entity);
        return entity;
    }

    public Page<IOrderMainVO> findAllOrdersByUserId(long userId, Pageable pageable) {
        Page<IOrderMainVO> page = repository.findByUserId(userId, pageable, IOrderMainVO.class);
        log.info("根据用户的 ID 查找所有的订单 - {} - {}", userId, page.getTotalElements());
        return page;
    }

    private final IOrderSerialService service;

    @Transactional(rollbackFor = Exception.class)
    public void createOrder(@Valid OrderMainCreateCommand command) {
        OrderMainEntity orderMain = OrderFactory.from(command, service);
        OrderMainEntity main = repository.save(orderMain);
        log.info("保存新的订单 {}", main);
    }

    @Transactional(rollbackFor = Exception.class)
    public void payCallback(@Valid @NotNull OrderPayCallbackCommand command) {
        Optional<OrderMainEntity> optional = repository.findById(command.getOrderId());
        if (optional.isPresent()) {
            callback(optional.get(), command);
            log.info("订单回调成功 - {} - {}", command, optional.get());
        } else {
            log.error("订单支付回调失败,找不到这个订单 - {}", command);
        }
    }

    private void callback(@NotNull OrderMainEntity entity, @NotNull OrderPayCallbackCommand command) {
        entity.setOrderStatus(command.getOrderStatus());
        entity.setPaymentType(command.getPaymentType());
        entity.setNote(command.getMessage());
    }

}
