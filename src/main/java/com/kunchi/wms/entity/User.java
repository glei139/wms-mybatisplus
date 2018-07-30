package com.kunchi.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
public class User extends SuperEntity<User> {


    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="用户id",name="ID",example="1")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value="用户名",name="UserName",example="admin")
    @TableField("UserName")
    private String UserName;

    @ApiModelProperty(value="密码",name="Pwd",example="admin")
    @TableField("Pwd")
    private String Pwd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", UserName=" + UserName +
        ", Pwd=" + Pwd +
        "}";
    }
}
