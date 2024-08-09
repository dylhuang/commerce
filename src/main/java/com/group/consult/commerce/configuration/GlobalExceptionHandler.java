package com.group.consult.commerce.configuration;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @title: 全局异常处理器
 * @description: 全局异常处理器
 * @author: zl
 * @date: 2024-08-08
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ApiResult handleGlobalException(BusinessException bx) {
        return ApiResult.result(bx.getCode(), bx.getMessage(), false, null);
    }

    @ExceptionHandler(Exception.class)
    public ApiResult handleException(Exception ex) {
        log.error("未知异常：", ex);
        return ApiResult.fail();
    }
}
