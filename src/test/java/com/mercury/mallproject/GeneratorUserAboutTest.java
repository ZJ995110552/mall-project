package com.mercury.mallproject;

import com.mercury.mallproject.common.utils.DateTimeUtil;
import com.mercury.mallproject.project.domain.SysRole;
import com.mercury.mallproject.project.domain.SysRoleUser;
import com.mercury.mallproject.project.domain.SysUser;
import com.mercury.mallproject.project.service.SysRoleService;
import com.mercury.mallproject.project.service.SysRoleUserService;
import com.mercury.mallproject.project.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GeneratorUserAboutTest {
    
    private static final int NUM = 20;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleUserService sysRoleUserService;


    @Test
    public void testAddUser() {
        DateTime now = DateTime.now();

        for (int i = 0; i < NUM; i++) {
            SysUser sysUser = new SysUser();

            String userid = DateTimeUtil.getCurrentDatePattern("yyMM") + String.format("%03d", i);

            String username = "user" + String.format("%03d", i);

            sysUser.setUserId(userid);

            sysUser.setUsername(username);

            sysUser.setPassword(username);

            sysUser.setCreateDate(now.toDate());
            sysUser.setCreator("ADMIN");

            sysUserService.save(sysUser);

            log.info("{}-----{}------生成成功！", userid, username);
        }


    }

    @Test
    public void testAddRole() {
        DateTime now = DateTime.now();

        for (int i = 0; i < NUM; i++) {
            SysRole sysRole = new SysRole();

            String userid = DateTimeUtil.getCurrentDatePattern("yyMM") + String.format("%03d", i);

            String rolename = "role" + String.format("%03d", i);

            sysRole.setName(rolename);

            sysRoleService.save(sysRole);

            log.info("角色[{}]------生成成功！", rolename);
        }
    }

    @Test
    public void testAddUserRole() {
        DateTime now = DateTime.now();

        List<SysUser> sysUsers = sysUserService.queryAll();

        List<SysRole> sysRoles = sysRoleService.queryAll();


        for (int i = 0; i < NUM; i++) {
            SysRoleUser sysRoleUser = new SysRoleUser();

            int rand = new Random().nextInt(NUM-1);
            int rand1 = new Random().nextInt(NUM-1);

            sysRoleUser.setRoleId(sysRoles.get(rand).getId());
            sysRoleUser.setUserId(sysUsers.get(rand1).getId());

            sysRoleUserService.save(sysRoleUser);

            log.info("用户[{}]与角色[{}]绑定成功！", sysUsers.get(rand1).getId(),sysRoles.get(rand1).getId());
        }
    }






}
