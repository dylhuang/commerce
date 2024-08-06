package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/05
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@TableName("user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 盐值
     */
    @TableField("salt_figure")
    private String saltFigure;

    /**
     * 加密密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户类型；0：内部用户；1：外部客户
     */
    @TableField("type")
    private Integer type;

}
