package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.ServiceUsageLog;
import com.group.consult.commerce.dao.mapper.ServiceUsageLogMapper;
import com.group.consult.commerce.persist.IServiceUsageLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务包使用记录 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Service
public class ServiceUsageLogServiceImpl extends ServiceImpl<ServiceUsageLogMapper, ServiceUsageLog> implements IServiceUsageLogService {

}
