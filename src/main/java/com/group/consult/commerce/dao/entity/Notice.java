package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.io.Serial;
import java.io.Serializable;

/**
 * 系统公告
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/13
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@TableName("notice")
public class Notice extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5218659533923375755L;

    /**
     * 公告标题
     */
    @TableField("title")
    private String title;

    /**
     * 公告摘要
     */
    @TableField("summary")
    private String summary;

    /**
     * 公告内容
     */
    @TableField("content")
    private String content;

    /**
     * 登录时弹窗是否启用；0：不启用；1：启用
     */
    @TableField("popup")
    private Integer popup;

}
