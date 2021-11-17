package com.matrixboot.mall.order.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 * <p>
 * create in 2021/11/16 11:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailCreateCommand {

    @NotNull
    Long skuId;

    @NotBlank
    String skuName;

    @NotBlank
    String skuSpec;

    @NotBlank
    String skuCode;

    @NotNull
    Long spuId;

    @NotBlank
    String spuName;

    @NotNull
    Long categoryId;

    @NotBlank
    String categoryName;

    @NotNull
    Integer count;

    @NotNull
    Integer price;

}



