package com.group.consult.commerce.model.dto;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlInjectionUtils;
import com.google.common.collect.Lists;
import com.group.consult.commerce.model.constant.BaseConstant;
import com.group.consult.commerce.utils.StringFormatUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 分页请求DTO
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/08
 */
@Schema(description = "分页请求DTO")
@Data
public class PageRequestDTO implements Serializable {

    @Schema(hidden = true)
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    @Schema(description = "当前页码", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(1)
    private Integer pageNum;

    /**
     * 每页大小
     */
    @Schema(description = "每页大小", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(1)
    private Integer pageSize;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private List<@Valid Sort> sorts;

    /**
     * 初始化参数值
     */
    public void init() {
        this.setPageNum(Optional.ofNullable(getPageNum())
                .orElse(BaseConstant.DEFAULT_NUM_OF_PAGES));
        this.setPageSize(Optional.ofNullable(getPageSize())
                .orElse(BaseConstant.DEFAULT_SIZE_OF_PAGES));
        this.setSorts(Optional.ofNullable(this.getSorts())
                .filter(CollectionUtils::isNotEmpty)
                .orElse(Lists.newArrayList(Sort.builder()
                        .sortField(BaseConstant.CREATED_TIME_COLUMN_NAME)
                        .sort(BaseConstant.DESC_COLUMN_NAME)
                        .build())));
    }

    public void initWithUpdateTimeSort() {
        this.setPageNum(Optional.ofNullable(getPageNum())
                .orElse(BaseConstant.DEFAULT_NUM_OF_PAGES));
        this.setPageSize(Optional.ofNullable(getPageSize())
                .orElse(BaseConstant.DEFAULT_SIZE_OF_PAGES));
        this.setSorts(Optional.ofNullable(this.getSorts())
                .filter(CollectionUtils::isNotEmpty)
                .orElse(Lists.newArrayList(Sort.builder()
                        .sortField(BaseConstant.UPDATE_TIME_COLUMN_NAME)
                        .sort(BaseConstant.DESC_COLUMN_NAME)
                        .build())));
    }

    /**
     * 初始化参数值 不默认排序
     */
    public void initWithoutSort() {
        this.setPageNum(Optional.ofNullable(getPageNum())
                .orElse(BaseConstant.DEFAULT_NUM_OF_PAGES));
        this.setPageSize(Optional.ofNullable(getPageSize())
                .orElse(BaseConstant.DEFAULT_SIZE_OF_PAGES));
        this.setSorts(Optional.ofNullable(this.getSorts())
                .filter(CollectionUtils::isNotEmpty)
                .orElse(Lists.newArrayList()));
    }

    @Schema
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Sort {

        /**
         * 排序字段
         */
        @Schema(description = "排序字段", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Pattern(regexp = "[a-zA-Z0-9]+")
        private String sortField;

        /**
         * 排序
         */
        @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
        @Pattern(regexp = "^(DESC|ASC)$")
        @NotBlank
        private String sort;

        public String toOrderByStatement() {
            // 防止SQL注入
            if (SqlInjectionUtils.check(this.getSortField())) {
                throw new RuntimeException();
            }
            return StringFormatUtils.getOrderByStatement(String.join(StringPool.UNDERSCORE, StringUtils.splitByCharacterTypeCamelCase(this.getSortField())), this.getSort());
        }
    }
}
