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
@Schema(description = "全局图像DTO")
public class ImageSpacePageableDTO extends PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 3287320643434880218L;

    /**
     * 图像名称
     */
    @Schema(description = "图像名称")
    private String name;

    /**
     * 图像类型
     */
    @Schema(description = "图像类型")
    private String type;

    /**
     * 图像状态 0：不可使用；1：可使用
     */
    @Schema(description = "图像状态")
    private String status;
}
