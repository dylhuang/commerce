package com.group.consult.commerce.persist;


import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;

/**
 * 商品表 服务类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
public interface IMerchandiseService extends IService<Merchandise> {

    Merchandise getMerchandiseById(long merchandiseId) throws BusinessException;

    boolean updateMerchandise(Merchandise merchandise) throws BusinessException;

    /**
     * 获取商品列表分页信息
     *
     * @param pageableDTO MerchandisePageableDTO
     * @return PageResult<MerchandiseVO>
     * @throws BusinessException BusinessException
     */
    PageResult<MerchandiseVO> getMerchandiseList(MerchandisePageableDTO pageableDTO) throws BusinessException;
}
