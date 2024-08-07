package com.group.consult.commerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Builder
@Data
public class ApiResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -421850957747247616L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应数据
     */
    private transient T data;

    /**
     * 响应时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Builder.Default
    private Date time = new Date();

    public static <T> ApiResult<T> result(int code, String message, boolean success, T data) {
        return ApiResult.<T>builder()
                .code(code)
                .message(message)
                .success(success)
                .data(data)
                .build();
    }

    public static <T> ApiResult<T> result(ApiCodeEnum apiCode, boolean success, T data) {
        return result(apiCode.getCode(), apiCode.getMessage(), success, data);
    }

    public static <T> ApiResult<T> success(T data) {
        return result(ApiCodeEnum.SUCCESS, true, data);
    }

    public static <T> ApiResult<T> success() {
        return success(null);
    }

    public static <T> ApiResult<T> fail(ApiCodeEnum apiCode, T data) {
        return Objects.isNull(apiCode) ? fail(data) : result(apiCode, false, data);
    }

    public static <T> ApiResult<T> fail(T data) {
        return result(ApiCodeEnum.FAIL, false, data);
    }

    public static <T> ApiResult<T> fail() {
        return fail(null);
    }
}