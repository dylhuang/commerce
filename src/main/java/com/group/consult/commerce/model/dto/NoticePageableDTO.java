package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Schema(description = "系统公告分页查询DTO")
public class NoticePageableDTO extends PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -4927906588803797915L;

    /**
     * 公告标题
     */
    @Schema(description = "公告标题")
    private String title;
}
