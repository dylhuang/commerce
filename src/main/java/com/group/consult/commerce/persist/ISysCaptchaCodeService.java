package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface ISysCaptchaCodeService extends IService<SysCaptchaCode> {

    /**
     * 存储验证码
     * @param captchaCode
     */
    void saveAndClearCaptchaCode(SysCaptchaCode captchaCode);

    /**
     * 根据uuid获取验证码信息
     * @param uuid
     * @return
     */
    SysCaptchaCode queryByUuid(String uuid);

    /**
     * 根据uuid清除
     * @param uuid
     */
    void clearByUuid(String uuid);

    /**
     * 清理过期code
     */
    void clearExpire();
}
