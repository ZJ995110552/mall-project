package com.mercury.mallproject;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.domain.SysLogOperation;
import com.mercury.mallproject.domain.SysUser;
import com.mercury.mallproject.repository.mapper.SysLogOperationMapper;
import com.mercury.mallproject.service.api.SysUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysLogOperationMapper sysLogOperationMapper;


    @Test
    public void testUser() {

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
    public void testQueryUser() {
        SysUser wy = sysUserService.queryByUserName("wy");

        SysUser sysUser1 = sysUserService.queryObject("001");

    }

    @Test
    public void testUtils() {
        logger.info("zj:" + DigestUtils.sha256Hex("zj"));
    }

    @Test
    public void testLogOp() {
        SysLogOperation sysLogOperation = new SysLogOperation();
        sysLogOperation.setId(idGenerator.generateId());
        sysLogOperation.setRequestTime(11111);
        sysLogOperation.setStatus(1);
        sysLogOperationMapper.insert(sysLogOperation);
    }

}
