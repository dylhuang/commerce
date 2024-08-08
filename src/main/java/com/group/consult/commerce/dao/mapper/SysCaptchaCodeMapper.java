package com.group.consult.commerce.dao.mapper;

import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface SysCaptchaCodeMapper extends BaseMapper<SysCaptchaCode> {

    /**
     * 删除过期数据
     * @return
     */
    @Delete("delete from sys_captcha_code where expire_time < now()")
    int deleteExpire();

    /**
     * 根据uuid删除验证码
     * @param uuid
     * @return
     */
    @Delete("delete from sys_captcha_code where uuid=#{uuid}")
    int deleteByUuid(@Param("uuid") String uuid);
}
