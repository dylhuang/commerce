CREATE TABLE if not exists `user`
 (
     `id`               BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
     `username`         VARCHAR(50)  DEFAULT NULL COMMENT '用户名',
     `salt_figure`      VARCHAR(50)  DEFAULT NULL COMMENT '盐值',
     `password`         VARCHAR(100) DEFAULT NULL COMMENT '加密密码',
     `type`             INT    NULL COMMENT '用户类型；0：内部用户；1：外部客户',
     `create_time`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `create_by`        VARCHAR(100) DEFAULT NULL COMMENT '创建人',
     `update_time`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     `update_by`        VARCHAR(100) DEFAULT NULL COMMENT '更新人',
     `is_del`           INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
     PRIMARY KEY (`id`),
     UNIQUE KEY `unique_username` (`username`) USING BTREE
 ) ENGINE = INNODB
   DEFAULT CHARSET = utf8mb4 COMMENT = '用户表';


 CREATE TABLE if not exists `user_role`
 (
     `id`               BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
     `user_id`          BIGINT NOT NULL COMMENT '用户ID',
     `role_id`          BIGINT NOT NULL COMMENT '角色ID',
     `create_time`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `create_by`        VARCHAR(100) DEFAULT NULL COMMENT '创建人',
     `update_time`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     `update_by`        VARCHAR(100) DEFAULT NULL COMMENT '更新人',
     `is_del`           INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
     PRIMARY KEY (`id`)
 ) ENGINE = INNODB
   DEFAULT CHARSET = utf8mb4 COMMENT = '用户角色表';

CREATE TABLE if not exists `role`
(
    `id`                   BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `code`                 VARCHAR(50)  DEFAULT NULL COMMENT '角色编码',
    `name`                 VARCHAR(50)  DEFAULT NULL COMMENT '角色名称',
    `description`          VARCHAR(100) DEFAULT NULL COMMENT '备注',
    `create_time`          datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`            VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`          datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`            VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`               INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_name` (`code`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '角色表';


CREATE TABLE if not exists `merchandise`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `merchandise_code`      VARCHAR(50)  DEFAULT NULL COMMENT '商品编码',
    `merchandise_name`      VARCHAR(50)  DEFAULT NULL COMMENT '商品名称',
    `status`                VARCHAR(36)  DEFAULT '20' COMMENT '商品状态 10:可销售  20:不可销售',
    `business_price`        DECIMAL(10, 3) DEFAULT NULL COMMENT 'To B价格：折扣价/日常单价',
    `business_enable`       INT          DEFAULT '0' COMMENT 'To B价格是否可销售；0：不可销售；1：可销售',
    `customer_price`        DECIMAL(10, 3) DEFAULT NULL COMMENT 'To C价格：原价/活动单价',
    `customer_enable`       INT          DEFAULT '0' COMMENT 'To C价格是否可销售；0：不可销售；1：可销售',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '商品表';


CREATE TABLE if not exists `merchandise_product`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `merchandise_id`        BIGINT  DEFAULT NULL COMMENT '商品ID',
    `product_id`            BIGINT  DEFAULT NULL COMMENT '产品ID',
    `product_number`        INT          DEFAULT null COMMENT '产品个数',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '商品产品表';


CREATE TABLE if not exists `product`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `code`                  VARCHAR(50)  DEFAULT NULL COMMENT '产品编码',
    `name`                  VARCHAR(50)  DEFAULT NULL COMMENT '产品名称',
    `status`                VARCHAR(36)  DEFAULT '10' COMMENT '产品状态 10:待发布  20:已发布',
    `price`                 DECIMAL(10, 3) DEFAULT NULL COMMENT '产品单价',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '产品表';


CREATE TABLE if not exists `product_service`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `product_id`            BIGINT  DEFAULT NULL COMMENT '商品ID',
    `service_type_id`       BIGINT  DEFAULT NULL COMMENT '服务类型ID',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '产品服务表';


CREATE TABLE if not exists `service_type`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `service_type_name`     VARCHAR(256)  DEFAULT NULL COMMENT '服务类型名称',
    `service_type_status`   VARCHAR(36)  DEFAULT NULL COMMENT '服务类型状态 10:可用  20:不可用',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '服务类型表';


CREATE TABLE if not exists `notice`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `title`                 VARCHAR(256)    DEFAULT NULL COMMENT '公告标题',
    `summary`               VARCHAR(1024)   DEFAULT NULL COMMENT '公告摘要',
    `content`               VARCHAR(1024)   DEFAULT NULL COMMENT '公告内容',
    `popup`                 INT              DEFAULT '0' COMMENT '登录时弹窗是否启用；0：不启用；1：启用',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '系统公告';


CREATE TABLE if not exists `image_space`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`                  VARCHAR(256)    DEFAULT NULL COMMENT '图像名称',
    `description`           VARCHAR(1024)   DEFAULT NULL COMMENT '图像描述',
    `type`                  VARCHAR(32)     DEFAULT NULL COMMENT '图像类型：10:首页广告位，20:其他',
    `status`                INT   DEFAULT '0' COMMENT '状态；0：不可使用；1：可使用',
    `image_url`             VARCHAR(1024)   DEFAULT NULL COMMENT '图像地址',
    `create_time`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             VARCHAR(100) DEFAULT NULL COMMENT '创建人',
    `update_time`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`             VARCHAR(100) DEFAULT NULL COMMENT '更新人',
    `is_del`                INT          DEFAULT '0' COMMENT '是否删除；0：未删除；1：删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '图像空间';