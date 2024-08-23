package com.group.consult.commerce.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.group.consult.commerce.dao.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 产品VO
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3302166517978777345L;

    /**
     * 产品编码
     */
    @Schema(description = "产品编码")
    private String code;

    /**
     * 产品名称
     */
    @Schema(description = "产品名称")
    private String name;

    /**
     * 产品状态 10:可使用  20:不可使用
     */
    @Schema(description = "产品状态 10:可使用  20:不可使用")
    private String status;

    /**
     * 产品单价
     */
    @Schema(description = "产品单价")
    private BigDecimal price;

    /**
     * 产品个数
     */
    @Schema(description = "产品个数")
    private Integer productNumber;

    /**
     * 关联的服务类型
     */
    @Schema(description = "关联的服务类型")
    private List<ServiceTypeVO> serviceTypeVOList;

    public static ProductVO of(Product product) {
        return ProductVO.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .status(product.getStatus())
                .price(product.getPrice())
                .createTime(product.getCreateTime())
                .createBy(product.getCreateBy())
                .updateBy(product.getUpdateBy())
                .updateTime(product.getUpdateTime())
                .build();
    }
}
