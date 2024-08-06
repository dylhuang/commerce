package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.User;
import com.group.consult.commerce.dao.mapper.UserMapper;
import com.group.consult.commerce.persist.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
