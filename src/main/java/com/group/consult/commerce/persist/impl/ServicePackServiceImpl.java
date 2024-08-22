package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.ServicePack;
import com.group.consult.commerce.dao.mapper.ServicePackMapper;
import com.group.consult.commerce.persist.IServicePackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务包 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Service
public class ServicePackServiceImpl extends ServiceImpl<ServicePackMapper, ServicePack> implements IServicePackService {

}
