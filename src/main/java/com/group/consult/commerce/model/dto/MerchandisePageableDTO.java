package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Schema(description = "商品分页查询DTO")
public class MerchandisePageableDTO extends PageRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6822371908887499109L;

    @Schema(description = "商品编号")
    private String merchandiseCode;

    @Schema(description = "商品名称")
    private String merchandiseName;

    @Schema(description = "商品状态 10:可销售  20:不可销售")
    private String status;
}
