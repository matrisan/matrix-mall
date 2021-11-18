package com.matrixboot.mall.goods.domain.entity;

import com.matrixboot.mall.common.annotation.Aggregate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * TODO
 * <p>
 * create in 2021/11/18 12:14 上午
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
@Table(name = "spec_param")
@DynamicUpdate
@DynamicInsert
public class SpecParamEntity {
}
