package com.matrixboot.mall.order.domain.repository;

import com.matrixboot.mall.order.domain.entity.OrderMainEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * <p>
 * create in 2021/11/16 8:49 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IOrderMainEntityRepository extends JpaRepository<OrderMainEntity, Long> {

    <T>  T findById(long orderId, Class<T> clz);

    <T> Page<T> findByUserId(long userId, Pageable pageable, Class<T> clz);

}
