package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.model.dto.SysUpdateUserPwdDTO;
import com.group.consult.commerce.model.vo.UpdatePersonInfoDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    SysUser findByUserName(String userName);

    /**
     * 修改个人信息
     * @param dto
     * @return
     */
    Boolean updatePersonInfo(UpdatePersonInfoDTO dto);

    /**
     * 修改登录用户密码
     * @param dto
     * @return
     */
    Boolean updatePwd(SysUpdateUserPwdDTO dto);
}
