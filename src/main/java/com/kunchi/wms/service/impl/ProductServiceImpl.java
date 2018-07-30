package com.kunchi.wms.service.impl;

import com.kunchi.wms.common.ReqProSerach;
import com.kunchi.wms.common.ResStore;
import com.kunchi.wms.entity.Product;
import com.kunchi.wms.mapper.ProductMapper;
import com.kunchi.wms.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public List<Product> selectProduct(ReqProSerach reqProSerach) {
         return baseMapper.selectProduct(reqProSerach);
    }

    @Override
    public List<ResStore> getResStore() {
        return baseMapper.getResStore();
    }
}
