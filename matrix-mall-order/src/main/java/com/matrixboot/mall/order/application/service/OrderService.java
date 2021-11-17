package com.matrixboot.mall.order.application.service;

import com.matrixboot.mall.order.application.OrderMainCreateCommand;
import com.matrixboot.mall.order.application.OrderFactory;
import com.matrixboot.mall.order.domain.entity.OrderMainEntity;
import com.matrixboot.mall.order.domain.repository.IOrderMainEntityRepository;
import com.matrixboot.mall.order.domain.service.IOrderSerialService;
import com.matrixboot.mall.order.domain.value.IOrderMainVO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * <p>
 * create in 2021/11/16 11:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
@Validated
@AllArgsConstructor
public class OrderService {

    private final IOrderSerialService service;

    private final IOrderMainEntityRepository repository;

    public Page<IOrderMainVO> findAllOrdersByUserId(long userId, Pageable pageable) {
        return repository.findByUserId(userId, pageable, IOrderMainVO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    public void createOrder(@Valid OrderMainCreateCommand command) {
        OrderMainEntity orderMain = OrderFactory.from(command, service);
        repository.save(orderMain);
    }


    @Transactional(rollbackFor = Exception.class)
    public void updateOrderStatus() {

    }


}
