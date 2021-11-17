package com.matrixboot.mall.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matrixboot.mall.common.annotation.Aggregate;
import com.matrixboot.mall.common.domain.BaseEntity;
import com.matrixboot.mall.common.value.OrderStatusEnum;
import com.matrixboot.mall.common.value.PaymentTypeEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * create in 2021/11/16 8:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Aggregate
@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_main", indexes = {@Index(name = "idx_user_id", columnList = "user_id")})
public class OrderMainEntity extends BaseEntity {

    private static final long serialVersionUID = -4124957277985601646L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    /**
     * 用户的 ID
     */
    @Column(name = "user_id", columnDefinition = "BIGINT COMMENT '用户ID'")
    Long userId;

    /**
     * 订单的序列号
     */
    @Column(name = "order_serial", columnDefinition = "CHAR(50) COMMENT '订单流水号'")
    String orderSerial;

    /**
     * 商户的 ID
     */
    @Column(name = "business_id", columnDefinition = "BIGINT COMMENT '电子邮箱'")
    Long businessId;

    /**
     * 手机号码
     */
    @Column(name = "mobile", columnDefinition = "CHAR(100) COMMENT '手机号码'")
    String mobile;

    /**
     * 订单的状态
     */
    @Column(name = "order_status", columnDefinition = "TINYINT COMMENT '订单状态'")
    @Enumerated(EnumType.ORDINAL)
    OrderStatusEnum orderStatus;

    /**
     * 支付类型
     */
    @Column(name = "payment_type", columnDefinition = "TINYINT COMMENT '支付类型'")
    @Enumerated(EnumType.ORDINAL)
    PaymentTypeEnum paymentType;

    /**
     * 总价
     */
    @Column(name = "total_price", columnDefinition = "INT COMMENT '订单总额'")
    Integer price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<OrderDetailEntity> orderDetails;

    /**
     * 订单没有过期
     *
     * @return boolean
     */
    public boolean orderNotExpired() {
        boolean notExpired = this.getCreateDate().plusMinutes(15).isAfter(LocalDateTime.now());
        this.setEnable(notExpired);
        this.orderStatus = OrderStatusEnum.ORDER_CLOSED;
        return notExpired;
    }

    /**
     * 订单没有过期
     *
     * @param timeout 过期时间
     * @return boolean
     */
    public boolean orderNotExpired(int timeout) {
        boolean notExpired = this.getCreateDate().plusMinutes(timeout).isAfter(LocalDateTime.now());
        this.setEnable(notExpired);
        this.orderStatus = OrderStatusEnum.ORDER_CLOSED;
        return notExpired;
    }

}
