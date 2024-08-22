package com.group.consult.commerce.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;

/**
 * @title: 通用工具
 * @description: 通用工具
 * @author: zl
 * @date: 2024-08-09
 */
public class GerneralUtil {

    public static void check(Boolean exp, ApiCodeEnum codeEnum) {
        if (exp) {
            throw new BusinessException(codeEnum);
        }
    }

    public static void assertCheck(Boolean exp, ApiCodeEnum codeEnum) {
        if (!exp) {
            throw new BusinessException(codeEnum);
        }
    }

    public static String randomCharacter(){
        return RandomUtil.randomStringUpper(10);
    }
}
