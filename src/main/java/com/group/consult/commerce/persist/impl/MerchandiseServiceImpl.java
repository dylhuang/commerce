package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.mapper.MerchandiseMapper;
import com.group.consult.commerce.persist.IMerchandiseService;
import org.springframework.stereotype.Service;

/**
 * 商品表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Service
public class MerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper, Merchandise> implements IMerchandiseService {

}
