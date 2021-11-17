package com.matrixboot.mall.order.interfaces.facade;

import com.matrixboot.mall.common.vo.ReturnVO;
import com.matrixboot.mall.order.application.OrderMainCreateCommand;
import com.matrixboot.mall.order.application.OrderPayCallbackCommand;
import com.matrixboot.mall.order.application.OrderUpdateCommand;
import com.matrixboot.mall.order.application.service.MatrixOrderService;
import com.matrixboot.mall.order.domain.value.IOrderMainVO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * create in 2021/11/17 12:20 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
@AllArgsConstructor
@RequestMapping("/matrix")
public class MatrixOrderFacade {

    private final MatrixOrderService service;

    @GetMapping("/mall/{userId}")
    public Page<IOrderMainVO> findAll(@PathVariable long userId, Pageable pageable) {
        return service.findAllOrdersByUserId(userId, pageable);
    }

    @PostMapping("/order")
    public ReturnVO<Void> createOrder(@RequestBody OrderMainCreateCommand command) {
        service.createOrder(command);
        return ReturnVO.success();
    }

    @PatchMapping("/pay/callback")
    public ReturnVO<Void> payCallback(@RequestBody OrderPayCallbackCommand command) {
        service.payCallback(command);
        return ReturnVO.success();
    }

}
