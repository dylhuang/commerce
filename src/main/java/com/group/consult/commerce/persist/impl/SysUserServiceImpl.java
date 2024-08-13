package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.configuration.interceptors.LoginUser;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.dao.mapper.SysUserMapper;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.dto.SysUpdateUserPwdDTO;
import com.group.consult.commerce.model.vo.UpdatePersonInfoDTO;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.utils.GerneralUtil;
import com.group.consult.commerce.utils.PasswordSaltGeneratorUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser findByUserName(String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUserName, userName);
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public Boolean updatePersonInfo(UpdatePersonInfoDTO dto) {
        LoginUser loginUser = LoginUser.getLoginSubject();
        Long userId = loginUser.getUserId();

        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(SysUser::getNickName, dto.getNickName());
        updateWrapper.lambda().set(SysUser::getEmail, dto.getEmail());
        updateWrapper.lambda().set(SysUser::getPhone, dto.getPhone());
        updateWrapper.lambda().set(SysUser::getGender, dto.getGender());
        updateWrapper.lambda().eq(SysUser::getId, userId);
        return update(updateWrapper);
    }

    @Override
    public Boolean updatePwd(SysUpdateUserPwdDTO dto) {
        LoginUser loginUser = LoginUser.getLoginSubject();
        GerneralUtil.check(loginUser == null, ApiCodeEnum.NOT_FIND_ERROR);
        SysUser user = getBaseMapper().selectById(loginUser.getUserId());
        GerneralUtil.check(user == null, ApiCodeEnum.NOT_FIND_ERROR);
        String dbPwd = user.getPassword();
        //校验原密码
        GerneralUtil.assertCheck(PasswordSaltGeneratorUtil.match(dto.getOldPwd(), dbPwd), ApiCodeEnum.OLD_PWD_ERROR);
        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(SysUser::getPassword, PasswordSaltGeneratorUtil.encode(dto.getNewPwd()));
        updateWrapper.lambda().eq(SysUser::getId, loginUser.getUserId());
        return update(updateWrapper);
    }
}
