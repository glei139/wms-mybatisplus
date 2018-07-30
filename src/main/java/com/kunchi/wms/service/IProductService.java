package com.kunchi.wms.service;

import com.kunchi.wms.common.ReqProSerach;
import com.kunchi.wms.common.ResStore;
import com.kunchi.wms.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
public interface IProductService extends IService<Product> {

    public List<Product> selectProduct(ReqProSerach reqProSerach);

    public List<ResStore> getResStore();

}
