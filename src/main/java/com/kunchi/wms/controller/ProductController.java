package com.kunchi.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kunchi.wms.common.ReqProSerach;
import com.kunchi.wms.common.ResStore;
import com.kunchi.wms.common.ResultMsg;
import com.kunchi.wms.entity.Product;
import com.kunchi.wms.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
@Api(value = "商品服务",description="商品服务")
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @ApiOperation(value = "获取商品列表接口", notes = "获取商品列表接口",produces = "application/json")
    @GetMapping("product")
    public ResultMsg<List<Product>> getProductList(ReqProSerach param){
        List<Product> list;


        QueryWrapper<Product> tiaojian = new QueryWrapper<Product>();

        if(param.getProductCode()!=null&&!param.getProductCode().isEmpty()){
            tiaojian.eq("productCode",param.getProductCode());
        }
        if(param.getProductName()!=null&&!param.getProductName().isEmpty()){
            tiaojian.like("productName",param.getProductName());
        }
        if(param.getStoreCode()!=null&&!param.getStoreCode().isEmpty()){
            tiaojian.eq("storeCode",param.getStoreCode());
        }
        if(param.getStoreName()!=null&&!param.getStoreName().isEmpty()){
            tiaojian.like("storeName",param.getStoreName());
        }
        tiaojian.orderByDesc("creatTime");


        IPage<Product> pagedata = productService.selectPage(new Page<Product>(param.getIndex(), param.getSize()),tiaojian );

        list = pagedata.getRecords();

        // list =productService.selectProduct(param);

        return new ResultMsg<List<Product>>(true,"ok",list,pagedata.getTotal());


    }

    @GetMapping("product/test")
    public IPage<Product> gettest(ReqProSerach param){

        IPage<Product> list= productService.selectPage(new Page<Product>(param.getIndex(), param.getSize()), null);
        return list;

    }

    @ApiOperation(value = "删除商品接口", notes = "删除商品接口",produces = "application/json")
    @DeleteMapping("product/{id}")
    public ResultMsg<Long> Delete( @ApiParam(value = "商品id" ,required = true, type = "Long") @PathVariable("id") Long id) {

        productService.delete(new QueryWrapper<Product>().eq("id",id));
        return new ResultMsg<Long>(true,"删除成功",id);

    }

    @ApiOperation(value = "商品按id查询接口", notes = "商品按id查询接口",produces = "application/json")
    @GetMapping("product/{id}")
    public ResultMsg<Product> GetByProductId( @ApiParam(value = "商品id" ,required = true, type = "Long") @PathVariable("id") Long id) {

        Product p = productService.selectOne(new QueryWrapper<Product>().eq("id",id));
        return new ResultMsg<Product>(true,"查询成功",p);

    }


    @ApiOperation(value = "修改商品接口", notes = "修改商品接口",produces = "application/json")
    @PutMapping("product")
    public ResultMsg<String> Put(@Valid @RequestBody Product product, BindingResult bindingResult) {


//        List<Product> pexistlist = productMapper.getByProductCode(product.getProductCode());
//        if(pexistlist.size()>1){
//
//            //检查1.1：该商品编码与商品名对应检查
//            if(!pexistlist.get(0).getProductName().equals(product.getProductName())){
//                return new ResultMsg<String>(false,"该商品编码对应商品名是："+pexistlist.get(0).getProductName()+"，请检查输入是否有误",null);
//            }
//
//        }
//        List<Product> pexistlist2 = productMapper.getByproductName(product.getProductName());
//        if(pexistlist2.size()>1){
//
//            //检查1.2：该商品商品名与编码对应检查
//            if(!pexistlist2.get(0).getProductCode().equals(product.getProductCode())){
//                return new ResultMsg<String>(false,"该商品名对应的编码是："+pexistlist2.get(0).getProductCode()+"，请检查输入是否有误",null);
//            }
//
//        }
//
//
//        //检查2：本仓库已存在该商品
//        List<Product> fiterlist = pexistlist.stream().filter(
//                e->e.getStoreCode().equals(product.getStoreCode())&&e.getId()!=product.getId()
//        ).collect(Collectors.toList());//过滤仓库code,id不同排除掉本身数据
//
//        if(fiterlist.size()>0) {
//            return new ResultMsg<String>(false, "操作失败:本仓库已存在该商品", null);
//        }
//
//        //检查3：仓库对应检查
//        List<ResStore> resStorelist=productMapper.getResStore();
//        List<ResStore> resStorelist1=resStorelist.stream().filter(
//                e->e.getStoreCode().equals(product.getStoreCode())
//        ).collect(Collectors.toList());//过滤仓库code;;
//        if(resStorelist1.size()>0) {
//            if (!resStorelist1.get(0).getStoreName().equals(product.getStoreName())) {
//                return new ResultMsg<String>(false, "该仓库编码对应名称是：" + resStorelist1.get(0).getStoreName() + "，请检查输入是否有误", null);
//            }
//        }
//        List<ResStore> resStorelist2=resStorelist.stream().filter(
//                e->e.getStoreName().equals(product.getStoreName())
//        ).collect(Collectors.toList());//过滤仓库名;;
//        if(resStorelist2.size()>0) {
//            if (!resStorelist2.get(0).getStoreCode().equals(product.getStoreCode())) {
//                return new ResultMsg<String>(false, "该仓库名对应的编码是：" + resStorelist2.get(0).getStoreCode() + "，请检查输入否有误", null);
//            }
//        }
        productService.updateById(product);

        return new ResultMsg<String>(true,"修改成功","");

    }



    @ApiOperation(value = "增加商品接口", notes = "增加商品接口",produces = "application/json")
    @PostMapping("product")
    public ResultMsg<String> Post(@Valid @RequestBody Product product, BindingResult bindingResult){

//        List<Product> pexistlist = productMapper.getByProductCode(product.getProductCode());
//        if(pexistlist.size()>0){
//
//            //检查1.1：该商品编码与商品名对应检查
//            if(!pexistlist.get(0).getProductName().equals(product.getProductName())){
//                return new ResultMsg<String>(false,"该商品编码对应商品名是："+pexistlist.get(0).getProductName()+"，请检查输入是否有误",null);
//            }
//
//        }
//        List<Product> pexistlist2 = productMapper.getByproductName(product.getProductName());
//        if(pexistlist2.size()>0){
//
//            //检查1.2：该商品商品名与编码对应检查
//            if(!pexistlist2.get(0).getProductCode().equals(product.getProductCode())){
//                return new ResultMsg<String>(false,"该商品名对应的编码是："+pexistlist2.get(0).getProductCode()+"，请检查输入是否有误",null);
//            }
//
//        }
//
//
//        //检查2：本仓库已存在该商品
//        List<Product> fiterlist = pexistlist.stream().filter(
//                e->e.getStoreCode().equals(product.getStoreCode())
//        ).collect(Collectors.toList());//过滤仓库code,id不同排除掉本身数据
//
//        if(fiterlist.size()>0) {
//            return new ResultMsg<String>(false, "操作失败:本仓库已存在该商品", null);
//        }
//
//        //检查3：仓库对应检查
//        List<ResStore> resStorelist=productMapper.getResStore();
//        List<ResStore> resStorelist1=resStorelist.stream().filter(
//                e->e.getStoreCode().equals(product.getStoreCode())
//        ).collect(Collectors.toList());//过滤仓库code;;
//        if(resStorelist1.size()>0) {
//            if (!resStorelist1.get(0).getStoreName().equals(product.getStoreName())) {
//                return new ResultMsg<String>(false, "该仓库编码对应名称是：" + resStorelist1.get(0).getStoreName() + "，请检查输入是否有误", null);
//            }
//        }
//        List<ResStore> resStorelist2=resStorelist.stream().filter(
//                e->e.getStoreName().equals(product.getStoreName())
//        ).collect(Collectors.toList());//过滤仓库名;;
//        if(resStorelist2.size()>0) {
//            if (!resStorelist2.get(0).getStoreCode().equals(product.getStoreCode())) {
//                return new ResultMsg<String>(false, "该仓库名对应的编码是：" + resStorelist2.get(0).getStoreCode() + "，请检查输入否有误", null);
//            }
//        }

        productService.insert(product);
        return new ResultMsg<String>(true,"新增成功","");
    }


    @ApiOperation(value = "获取仓库列表接口", notes = "获取仓库列表接口",produces = "application/json")
    @GetMapping("store")
    public ResultMsg<List<ResStore>> getStore(){
        List<ResStore> list=productService.getResStore();
        return new ResultMsg<List<ResStore>>(true,"ok",list);

    }



}

