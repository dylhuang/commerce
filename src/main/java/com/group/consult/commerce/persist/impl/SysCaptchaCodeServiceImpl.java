package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.group.consult.commerce.dao.mapper.SysCaptchaCodeMapper;
import com.group.consult.commerce.persist.ISysCaptchaCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Service
public class SysCaptchaCodeServiceImpl extends ServiceImpl<SysCaptchaCodeMapper, SysCaptchaCode> implements ISysCaptchaCodeService {
    @Override
    public void saveAndClearCaptchaCode(SysCaptchaCode captchaCode) {
        getBaseMapper().deleteExpire();
        getBaseMapper().insert(captchaCode);
    }

    @Override
    public SysCaptchaCode queryByUuid(String uuid) {
        QueryWrapper<SysCaptchaCode> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysCaptchaCode::getUuid, uuid);
        queryWrapper.lambda().ge(SysCaptchaCode::getExpireTime, new Date());
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public void clearByUuid(String uuid) {
        getBaseMapper().deleteByUuid(uuid);
    }

    @Override
    public void clearExpire() {
        getBaseMapper().deleteExpire();
    }
}
