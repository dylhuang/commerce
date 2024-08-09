package com.group.consult.commerce.exception;

import com.group.consult.commerce.model.ApiCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Demo Controller
 *
 * @author Huang, Dylan Bo
 * @since 2024-08-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private int code;

    private String message;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ApiCodeEnum apiCodeEnum) {
        this(apiCodeEnum.getCode(), apiCodeEnum.getMessage());
    }

}
