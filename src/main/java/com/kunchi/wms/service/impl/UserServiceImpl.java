package com.kunchi.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.kunchi.wms.entity.User;
import com.kunchi.wms.mapper.UserMapper;
import com.kunchi.wms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author genglei
 * @since 2018-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public List<User> selectListBySQL() {
        return baseMapper.selectListBySQL();
    }

    @Override
    public List<User> selectListByWrapper(Wrapper wrapper) {
        return baseMapper.selectListByWrapper(wrapper);
    }

}
