package com.group.consult.commerce.service;

import com.group.consult.commerce.model.vo.LoginInfoVO;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/**
 * 本地缓存Service
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/06
 */
public interface ICacheService {

    /**
     * 保存登录信息
     *
     * @param token       token
     * @param loginInfoVO LoginInfoVO
     */
    void saveLoginToken(String token, LoginInfoVO loginInfoVO);

    /**
     * 根据token获取登录信息
     *
     * @param token token
     * @return result
     */
    LoginInfoVO getLoginInfoByToken(String token);

    /**
     * 删除登录信息
     *
     * @param token token
     */
    void removeLoginToken(String token);

    /**
     * 删除登录信息
     *
     * @param tokens token集合
     */
    void removeLoginToken(Collection<String> tokens);

    /**
     * 保存客户token
     *
     * @param customerName 客户名称
     * @param token        token
     */
    void saveCustomerToken(String customerName, String token);

    /**
     * 获取客户token集合
     *
     * @param customerName token
     * @return result
     */
    Set<String> getCustomerTokenSet(String customerName);

    /**
     * 删除客户token
     *
     * @param customerName 客户名称
     * @param token        token
     */
    void removeCustomerToken(String customerName, String token);

    /**
     * 删除客户token集合
     *
     * @param customerName 客户名称
     */
    void removeCustomerTokenSet(String customerName);

    /**
     * 保存定时任务
     *
     * @param type   类型
     * @param id     ID
     * @param future ScheduledFuture
     */
    void saveCron(String type, Integer id, ScheduledFuture<?> future);

    /**
     * 获取定时任务
     *
     * @param type 类型
     * @param id   ID
     * @return result
     */
    ScheduledFuture<?> getCron(String type, Integer id);

    /**
     * 获取定时任务
     *
     * @param type 类型
     * @return result
     */
    Map<Integer, ScheduledFuture<?>> getCronMap(String type);

    /**
     * 删除定时任务
     *
     * @param type 类型
     * @param id   ID
     */
    void removeCron(String type, Integer id);
}
