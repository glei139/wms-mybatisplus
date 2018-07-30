package com.kunchi.wms.test;

import com.kunchi.wms.Application;
import com.kunchi.wms.entity.User;
import com.kunchi.wms.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class AppTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testselectListBySQL() {
        List<User> list =userMapper.selectListBySQL();
        System.out.println("success!");
    }


}
