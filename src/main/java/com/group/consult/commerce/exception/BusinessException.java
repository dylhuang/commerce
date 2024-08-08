package com.group.consult.commerce.exception;

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

    private String code;

    private String message;
}
