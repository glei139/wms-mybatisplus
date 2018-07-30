package com.kunchi.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kunchi.wms.common.ReqUserPwd;
import com.kunchi.wms.common.ResultMsg;
import com.kunchi.wms.entity.User;
import com.kunchi.wms.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
@Api(value = "登陆服务",description="登陆服务")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登陆接口", notes = "登陆接口",produces = "application/json")
    @PostMapping("login")
    public ResultMsg<String> login(@Valid @RequestBody ReqUserPwd user, BindingResult bindingResult){

        User obj = userService.selectOne(new QueryWrapper<User>().eq("UserName",user.getUserName()));

        if(obj!=null) {
            if(obj.getPwd().equals(user.getPwd())){

                return new ResultMsg<String>(true,"登陆成功","");
            }else {
                return new ResultMsg<String>(false,"用户名或密码错误","");
            }

        }
        else
        {
            return new ResultMsg<String>(false,"用户名不存在","");
        }

    }


    @GetMapping("user/add")
    public Object addUser() {
        User user = new User();

        Random r =new Random();
         String s ="gl"+r.nextInt();
        user.setUserName(s);
        user.setPwd(s);
        //return userService.insert(user);
        return   user.insert();
    }

    @GetMapping("/select_wrapper")
    public Object getUserByWrapper() {
        return userService.selectList(new QueryWrapper<User>().like("UserName","gl"));
        //return userService.selectListByWrapper(new QueryWrapper<User>().eq("UserName","admin"));
    }



}

