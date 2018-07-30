package com.kunchi.wms.common;

import io.swagger.annotations.ApiModelProperty;

public class ReqPage {

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @ApiModelProperty(value="页码",name="index",example="1")
    private int index = 0;

    @ApiModelProperty(value="每页行数",name="size",example="10")
    private int size = 10;

}
