package com.mercury.mallproject.project.service.impl;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.project.domain.SysRoleUser;
import com.mercury.mallproject.project.mapper.SysRoleUserMapper;
import com.mercury.mallproject.project.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public int save(SysRoleUser sysRoleUser) {
        sysRoleUser.setId(idGenerator.generateId());
        return sysRoleUserMapper.insert(sysRoleUser);
    }
}
