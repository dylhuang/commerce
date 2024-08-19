package com.group.consult.commerce.model.vo;

import com.group.consult.commerce.dao.entity.ImageSpace;
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
public class ImageSpaceVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2489427656832712515L;

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
     * 状态；0：不可使用；1：可使用
     */
    @Schema(description = "状态；0：不可使用；1：可使用")
    private Integer status;

    /**
     * 图像地址
     */
    @Schema(description = "图像地址")
    private String imageUrl;

    public static ImageSpaceVO of(ImageSpace imageSpace) {
        return ImageSpaceVO.builder()
                .id(imageSpace.getId())
                .name(imageSpace.getName())
                .description(imageSpace.getDescription())
                .type(imageSpace.getType())
                .status(imageSpace.getStatus())
                .imageUrl(imageSpace.getImageUrl())
                .createTime(imageSpace.getCreateTime())
                .createBy(imageSpace.getCreateBy())
                .updateBy(imageSpace.getUpdateBy())
                .updateTime(imageSpace.getUpdateTime())
                .build();
    }
}