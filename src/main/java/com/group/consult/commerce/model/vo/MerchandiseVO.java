package com.group.consult.commerce.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.group.consult.commerce.dao.entity.BaseEntity;
import com.group.consult.commerce.dao.entity.Merchandise;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品VO
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4484616707433984878L;

    /**
     * 商品编码
     */
    @Schema(description = "商品编码")
    private String merchandiseCode;

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String merchandiseName;

    /**
     * 商品状态 10:可销售  20:不可销售
     */
    @Schema(description = "商品状态 10:可销售  20:不可销售")
    private String status;

    /**
     * To B价格：折扣价/日常单价
     */
    @Schema(description = "To B价格：折扣价/日常单价")
    private BigDecimal businessPrice;

    /**
     * To B价格是否可销售；0：不可销售；1：可销售
     */
    @Schema(description = "To B价格是否可销售；0：不可销售；1：可销售")
    private Integer businessEnable;

    /**
     * To C价格：原价/活动单价
     */
    @Schema(description = "To C价格：原价/活动单价")
    private BigDecimal customerPrice;

    /**
     * To C价格是否可销售；0：不可销售；1：可销售
     */
    @Schema(description = "To C价格是否可销售；0：不可销售；1：可销售")
    private Integer customerEnable;

    @Schema(description = "关联的服务类型")
    private List<ServiceTypeVO> serviceTypeVOList;

    public static MerchandiseVO of(Merchandise merchandise) {
        return MerchandiseVO.builder()
                .id(merchandise.getId())
                .merchandiseCode(merchandise.getMerchandiseCode())
                .merchandiseName(merchandise.getMerchandiseName())
                .status(merchandise.getStatus())
                .businessPrice(merchandise.getBusinessPrice())
                .businessEnable(merchandise.getBusinessEnable())
                .customerPrice(merchandise.getCustomerPrice())
                .customerEnable(merchandise.getCustomerEnable())
                .createTime(merchandise.getCreateTime())
                .createBy(merchandise.getCreateBy())
                .updateBy(merchandise.getUpdateBy())
                .updateTime(merchandise.getUpdateTime())
                .build();
    }
}
