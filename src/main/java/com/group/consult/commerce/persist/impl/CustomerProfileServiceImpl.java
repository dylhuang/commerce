package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.CustomerProfile;
import com.group.consult.commerce.dao.mapper.CustomerProfileMapper;
import com.group.consult.commerce.persist.ICustomerProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员个人资料 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Service
public class CustomerProfileServiceImpl extends ServiceImpl<CustomerProfileMapper, CustomerProfile> implements ICustomerProfileService {

}
