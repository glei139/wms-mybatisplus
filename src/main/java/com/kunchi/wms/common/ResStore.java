package com.kunchi.wms.common;

import io.swagger.annotations.ApiModelProperty;

public class ResStore {

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


    @ApiModelProperty(value="仓库编码",name="storeCode",example="001")
    private String storeCode;

    @ApiModelProperty(value="仓库名称",name="storeName",example="北京仓库")
    private String storeName;
}

