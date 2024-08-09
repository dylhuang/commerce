package com.group.consult.commerce.exception;

import com.group.consult.commerce.model.ApiCodeEnum;
import lombok.Getter;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Business Exceptions
 *
 * @author Huang, Dylan Bo
 * @since 2024-08-08
 */
@Getter
public class BusinessException extends RuntimeException {

    private final ApiCodeEnum code;

    private Object data;

    public BusinessException(ApiCodeEnum code) {
        super(code.getMessage());
        this.code = code;
    }

    public BusinessException(ApiCodeEnum code, Object data) {
        super(code.getMessage());
        this.code = code;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return Stream.of(this.getCode().getMessage(), Optional.ofNullable(this.getData())
                        .map(Object::toString)
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.joining(":"));
    }
}
