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