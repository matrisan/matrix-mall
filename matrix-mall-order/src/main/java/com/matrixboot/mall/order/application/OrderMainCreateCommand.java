package com.matrixboot.mall.order.application;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matrixboot.mall.common.value.OrderStatusEnum;
import com.matrixboot.mall.common.value.PaymentTypeEnum;
import com.matrixboot.mall.order.domain.entity.OrderDetailEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/11/16 11:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderMainCreateCommand {

    @NotNull
    Long userId;

    @NotNull
    Long businessId;

    @NotBlank
    String mobile;

    @NotNull
    OrderStatusEnum orderStatus;

    @NotNull
    PaymentTypeEnum paymentType;

    @Size(min = 1)
    List<OrderDetailCreateCommand> orderDetails;

}


