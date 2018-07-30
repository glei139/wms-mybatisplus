package com.kunchi.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.kunchi.wms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
public interface IUserService extends IService<User> {

    public List<User> selectListBySQL();

    public List<User> selectListByWrapper(Wrapper wrapper);

}
