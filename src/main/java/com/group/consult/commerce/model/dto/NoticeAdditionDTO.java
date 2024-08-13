package com.group.consult.commerce.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.group.consult.commerce.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("notice")
public class NoticeAdditionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4252593317004821445L;

    /**
     * 公告标题
     */
    @Schema(description = "公告标题")
    private String title;

    /**
     * 公告摘要
     */
    @Schema(description = "公告摘要")
    private String summary;

    /**
     * 公告内容
     */
    @Schema(description = "公告内容")
    private String content;

    /**
     * 登录时弹窗是否启用；0：不启用；1：启用
     */
    @Schema(description = "登录时弹窗是否启用；0：不启用；1：启用")
    private Integer popup;
}
