package com.matrixboot.mall.order.infrastructure.repository;

import com.matrixboot.mall.order.domain.entity.OrderMainEntity;
import org.jetbrains.annotations.NotNull;

/**
 * 过期
 * <p>
 * create in 2021/11/17 2:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class OrderExpireProjection {

    public boolean expire(@NotNull OrderMainEntity entity) {
        return entity.orderNotExpired();
    }

}
