package com.kunchi.wms.common;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class ReqUserPwd {

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        @ApiModelProperty(value="用户名",name="userName",required=true,example="admin")
        @NotEmpty(message = "用户名不能为空")
        private String userName;

        @ApiModelProperty(value="密码",name="pwd",required=true,example="admin")
        @NotEmpty(message = "密码不能为空")
        private String pwd;

}
