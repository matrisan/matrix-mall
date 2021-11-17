package com.matrixboot.mall.order.interfaces.facade;

import com.matrixboot.mall.order.application.service.OrderService;
import com.matrixboot.mall.order.domain.value.IOrderMainVO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/11/17 12:20 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
@AllArgsConstructor
public class MatrixOrderFacade {

    private final OrderService service;

    @GetMapping("/matrix/mall/{userId}")
    public Page<IOrderMainVO> findAll(@PathVariable long userId, Pageable pageable) {
        return service.findAllOrdersByUserId(userId, pageable);

    }

}
