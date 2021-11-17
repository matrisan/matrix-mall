package com.matrixboot.mall.order.infrastructure.common;

import cn.hutool.core.lang.ObjectId;
import com.matrixboot.mall.order.domain.service.IOrderSerialService;
import org.springframework.stereotype.Component;

/**
 * <p>
 * create in 2021/11/17 9:20 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Component
public class OrderSerialServiceMongoImpl implements IOrderSerialService {

    @Override
    public String generateOrderSerial() {
        return ObjectId.next();
    }
}
