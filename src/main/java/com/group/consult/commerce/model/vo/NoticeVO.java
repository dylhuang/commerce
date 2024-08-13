package com.group.consult.commerce.model.vo;

import com.group.consult.commerce.dao.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4738372793291408326L;

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

    public static NoticeVO of(Notice notice) {
        return NoticeVO.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .summary(notice.getSummary())
                .content(notice.getContent())
                .popup(notice.getPopup())
                .createTime(notice.getCreateTime())
                .createBy(notice.getCreateBy())
                .updateBy(notice.getUpdateBy())
                .updateTime(notice.getUpdateTime())
                .build();
    }
}