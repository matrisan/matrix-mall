package com.matrixboot.mall.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matrixboot.mall.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TODO
 * <p>
 * create in 2021/11/16 8:44 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
@Entity
@Table(name = "order_detail", indexes = {@Index(name = "idx_order_main_id", columnList = "order_main_id")})
public class OrderDetailEntity extends BaseEntity {

    private static final long serialVersionUID = -2371564044739796477L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "sku_id", columnDefinition = "BIGINT COMMENT 'sku_id'")
    Long skuId;

    @Column(name = "sku_name", columnDefinition = "VARCHAR(100) COMMENT 'skuName'")
    String skuName;

    @Column(name = "sku_spec", columnDefinition = "VARCHAR(250) COMMENT 'skuSpec'")
    String skuSpec;

    @Column(name = "sku_code", columnDefinition = "VARCHAR(20) COMMENT 'skuCode'")
    String skuCode;

    @Column(name = "spu_id", columnDefinition = "BIGINT COMMENT 'spuId'")
    Long spuId;

    @Column(name = "spu_name", columnDefinition = "VARCHAR(50) COMMENT 'spuName'")
    String spuName;

    @Column(name = "category_id", columnDefinition = "BIGINT COMMENT '类目'")
    Long categoryId;

    @Column(name = "category_name", columnDefinition = "VARCHAR(20) COMMENT 'categoryName'")
    String categoryName;

    /**
     * 订购数量
     */
    @Column(name = "count", columnDefinition = "INT COMMENT 'time'")
    Integer count;

    /**
     * 单价
     */
    @Column(name = "price", columnDefinition = "INT COMMENT '价格'")
    Integer price;

    @Column(name = "order_main_id", insertable = false, updatable = false)
    Long orderMainId;

    @ManyToOne()
    @JoinColumn(name = "order_main_id", referencedColumnName = "id")
    @JsonBackReference
    OrderMainEntity orderMain;

}
