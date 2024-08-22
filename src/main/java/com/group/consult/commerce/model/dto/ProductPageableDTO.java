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
@Schema(description = "产品分页查询DTO")
public class ProductPageableDTO extends PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 6822371908887499109L;

    @Schema(description = "产品编号")
    private String code;

    @Schema(description = "产品名称")
    private String name;

    @Schema(description = "产品状态 10:可使用  20:不可使用")
    private String status;
}
