package com.kunchi.wms.common;


import io.swagger.annotations.ApiModelProperty;

public class ResultMsg <T> {

    public ResultMsg(){

    }

    public ResultMsg(Boolean suc,String msg,T obj){
        setSuc(suc);
        setMsg(msg);
        setObj(obj);
    }

    public ResultMsg(Boolean suc,String msg,T obj,Long total){
        setSuc(suc);
        setMsg(msg);
        setObj(obj);
        setTotal(total);
    }


    @ApiModelProperty(value="是否成功",name="suc",required=true,example="true")
    private Boolean suc  ;

    @ApiModelProperty(value="返回消息",name="msg",required=true,example="操作成功")
    private String msg ;

    @ApiModelProperty(value="返回数据",name="obj",required=false)
    private T obj ;


    @ApiModelProperty(value="分页查询总条数(非必须)",name="total",required=false,example="0")
    private Long total;
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean getSuc() {
        return suc;
    }

    public void setSuc(Boolean suc) {
        this.suc = suc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }


}

