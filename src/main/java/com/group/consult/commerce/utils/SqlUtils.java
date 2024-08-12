package com.group.consult.commerce.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.group.consult.commerce.model.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * SQL工具类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/08
 */
@Slf4j
public class SqlUtils {

    public static void commonOrderBy(List<PageRequest.Sort> sorts, LambdaQueryWrapper<?> wrapper) {
        Optional.ofNullable(sorts)
                .filter(CollectionUtils::isNotEmpty)
                .ifPresent(list -> wrapper.last(toOrderBy(sorts)));
    }

    public static String toOrderBy(List<PageRequest.Sort> sorts) {
        return Optional.ofNullable(sorts)
                .filter(CollectionUtils::isNotEmpty)
                .map(list -> StringFormatUtils.getOrderByFullStatement(list.stream()
                        .map(PageRequest.Sort::toOrderByStatement)
                        .collect(Collectors.joining(StringPool.COMMA))))
                .orElse("id");
    }
}
