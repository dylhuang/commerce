package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.Customer;
import com.group.consult.commerce.dao.mapper.CustomerMapper;
import com.group.consult.commerce.persist.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
