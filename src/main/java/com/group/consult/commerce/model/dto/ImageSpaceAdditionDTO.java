package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageSpaceAdditionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2435938346201498655L;

    /**
     * 图像名称
     */
    @Schema(description = "图像名称")
    private String name;

    /**
     * 图像描述
     */
    @Schema(description = "图像描述")
    private String description;

    /**
     * 图像类型：10:首页广告位，20:其他
     */
    @Schema(description = "图像类型：10:首页广告位，20:其他")
    private String type;

    /**
     * 图像地址
     */
    @Schema(description = "图像地址")
    private String imageUrl;
}