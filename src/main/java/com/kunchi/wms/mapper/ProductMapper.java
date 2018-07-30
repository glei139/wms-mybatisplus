package com.kunchi.wms.mapper;

import com.kunchi.wms.common.ReqProSerach;
import com.kunchi.wms.common.ResStore;
import com.kunchi.wms.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
public interface ProductMapper extends BaseMapper<Product> {

    //xml配置查询
    public List<Product> selectProduct(@Param("reqProSerach") ReqProSerach reqProSerach);

    //仓库查询
    @Select("select DISTINCT storeCode,storeName from product ")
    public List<ResStore> getResStore();


}
