package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group.consult.commerce.dao.entity.ServiceType;
import com.group.consult.commerce.dao.mapper.ServiceTypeMapper;
import com.group.consult.commerce.persist.IServiceTypeService;
import org.springframework.stereotype.Service;

/**
 * 服务类型表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Service
public class ServiceTypeServiceImpl extends ServiceImpl<ServiceTypeMapper, ServiceType> implements IServiceTypeService {

}
