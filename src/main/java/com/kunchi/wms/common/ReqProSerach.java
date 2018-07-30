package com.kunchi.wms.common;


import io.swagger.annotations.ApiModelProperty;

public class ReqProSerach extends ReqPage {
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

    @ApiModelProperty(value="商品编码",name="productCode",required=false,example="0001")
    private String productCode;
    @ApiModelProperty(value="商品名称",name="productName",required=false,example="商品A")
    private String productName;
    @ApiModelProperty(value="仓库编码",name="storeCode",required=false,example="001")
    private String storeCode;
    @ApiModelProperty(value="仓库名称",name="storeName",required=false,example="北京仓库")
    private String storeName;
}

