package com.group.consult.commerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 待完善
 *
 * @title: Demo Controller
 * @description: Demo
 * @author: Huang, Dylan Bo
 * @date: 2024-08-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private String code;

    private String message;
}
