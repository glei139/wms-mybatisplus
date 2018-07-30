package com.kunchi.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
@ApiModel(value="Product",description="商品对象")
public class Product extends SuperEntity<Product> {

    private static final long serialVersionUID = 2L;

    @ApiModelProperty(value="商品id",name="id",example="9")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品编码
     */
    @TableField("productCode")
    @NotEmpty(message = "商品编码不能为空")
    @ApiModelProperty(value="商品编码",name="productCode",example="0009")
    private String productCode;
    /**
     * 商品名称
     */
    @TableField("productName")
    @ApiModelProperty(value="商品名称",name="productName",example="商品6")
    private String productName;
    /**
     * 仓库编码
     */
    @TableField("storeCode")
    @NotEmpty(message = "仓库编码不能为空")
    @ApiModelProperty(value="仓库编码",name="storeCode",example="002")
    private String storeCode;
    /**
     * 仓库名称
     */
    @TableField("storeName")
    @ApiModelProperty(value="仓库名称",name="storeName",example="上海仓库")
    private String storeName;
    /**
     * 库存
     */
    @Range(min=0, max=99999,message = "库存需要在0~999999之间")
    @ApiModelProperty(value="库存",name="inventory",example="30")
    private Integer inventory;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",name="creatTime",example="2018-07-23T13:50:20",required = false)
    @TableField("creatTime")
    private LocalDateTime creatTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", id=" + id +
        ", productCode=" + productCode +
        ", productName=" + productName +
        ", storeCode=" + storeCode +
        ", storeName=" + storeName +
        ", inventory=" + inventory +
        ", creatTime=" + creatTime +
        "}";
    }
}
