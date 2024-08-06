package com.group.consult.commerce.service;

import com.group.consult.commerce.exception.BusinessException;

/**
 * @title: IDemoService interface
 * @description: IDemoService interface description
 * @author: Huang, Dylan Bo
 * @date: 2024-08-05
 */
public interface IDemoService {

    /**
     * @title handle the logic
     * @param prefix prefix
     * @param suffix suffix
     * @throws BusinessException BusinessException
     */
    void handle(String prefix, String suffix) throws BusinessException;
}
