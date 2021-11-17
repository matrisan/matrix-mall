package com.matrixboot.mall.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 领域对象的公共父类
 * <p>
 * create in 2021/7/1 2:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2800451702641413657L;

    /**
     * 创建时间
     */
    @Column(name = "create_date", columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    protected LocalDateTime createDate;

    /**
     * 最后更新时间
     */
    @Column(name = "last_modified_date", columnDefinition = "DATETIME COMMENT '最后更新时间'")
    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;

    /**
     * 是否启用
     */
    @Column(name = "enable", columnDefinition = "TINYINT COMMENT '是否启用'")
    protected Boolean enable;

    /**
     * 数据库中的版本号
     */
    @Version
    @Column(columnDefinition = "BIGINT NOT NULL DEFAULT 0 COMMENT '版本号-乐观锁'")
    protected Long version;

    /**
     * 创建人
     */
    @Column(name = "created_by", columnDefinition = "BIGINT DEFAULT 0 COMMENT '创建人'")
    protected Long createdBy;

    /**
     * 备注信息
     */
    @Column(columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '备注信息'")
    protected String note;

}
