package com.mercury.mallproject;

import com.mercury.mallproject.domain.SysUser;
import com.mercury.mallproject.service.api.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Autowired
    private SysUserService sysUserService;


    @Test
    public void testUser(){

        SysUser sysUser = new SysUser();

        sysUser.setId(1111L);
        sysUser.setUserId("001");
        sysUser.setUsername("zj");

        sysUserService.save(sysUser);

        sysUser.setId(1112L);
        sysUser.setUserId("002");
        sysUser.setUsername("wy");

        sysUserService.save(sysUser);
    }
    
    @Test
    public void testQueryUser(){
        SysUser wy = sysUserService.queryByUserName("wy");

        SysUser sysUser1 = sysUserService.queryObject("001");

    }
}
