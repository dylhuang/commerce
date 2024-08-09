package com.group.consult.commerce.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 分页结果
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/08
 */
@Schema(description = "分页结果")
@Builder
@Data
public class PageResult<T> {

    /**
     * 总数量
     */
    @Schema(description = "总数量")
    private Long total;

    /**
     * 总页数
     */
    @Schema(description = "总页数")
    private Long totalPages;

    /**
     * 每页大小
     */
    @Schema(description = "每页大小")
    private Long pageSize;

    /**
     * 当前页码
     */
    @Schema(description = "当前页码")
    private Long pageNum;

    /**
     * 列表
     */
    @Schema(description = "列表")
    private List<T> list;

    public static <T> PageResult<T> of(List<T> list, IPage<?> page) {
        return PageResult.<T>builder()
                .list(list)
                .total(page.getTotal())
                .pageSize(page.getSize())
                .pageNum(page.getCurrent())
                .totalPages(page.getPages())
                .build();
    }
}
