package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Getter
@Setter
@TableName("sys_captcha_code")
public class SysCaptchaCode extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 验证码 */
    @TableField("code")
    private String code;

    /** uuid */
    @TableField("uuid")
    private String uuid;

    /** 过期时间 */
    @TableField("expire_time")
    private LocalDateTime expireTime;

}
