package com.matrixboot.mall.common.value;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 * <p>
 * create in 2021/11/16 8:47 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public enum OrderStatusEnum {

    /**
     * 审核中(待支付)
     * 这个字段用来判断用户是否有正在进行的订单,如果有则不允许用户创建新的订单
     */
    ORDER_UNPAID(0, "待支付"),

    /**
     * 审核完成-成功(已支付)
     */
    ORDER_PAID(1, "支付成功"),

    /**
     * 审核完成-失败(支付失败)
     */
    ORDER_FAILED(2, "支付失败"),

    /**
     * 取消申请
     */
    ORDER_CANCEL(3, "取消申请"),

    /**
     * 审核中
     */
    UNDER_REVIEW(4, "审核中"),

    /**
     * 审核失败
     */
    REVIEW_FAILURE(5, "审核失败"),

    /**
     * 交易关闭
     */
    ORDER_CLOSED(6, "交易关闭");

    @Getter
    private final int value;

    @Getter
    private final String message;

    OrderStatusEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    /**
     * 所有枚举类的集合
     */
    public static final Map<Integer, OrderStatusEnum> MAP = Arrays.stream(OrderStatusEnum.values()).collect(Collectors.toMap(x -> x.value, x -> x));


}
