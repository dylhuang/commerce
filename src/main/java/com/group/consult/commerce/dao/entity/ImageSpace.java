package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

/**
 * 图像空间
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/19
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@TableName("image_space")
public class ImageSpace extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 3443616086527568499L;

    /**
     * 图像名称
     */
    @TableField("name")
    private String name;

    /**
     * 图像描述
     */
    @TableField("description")
    private String description;

    /**
     * 图像类型：10:首页广告位，20:其他
     */
    @TableField("type")
    private String type;

    /**
     * 状态；0：不可使用；1：可使用
     */
    @TableField("status")
    private Integer status;

    /**
     * 图像地址
     */
    @TableField("image_url")
    private String imageUrl;
}
