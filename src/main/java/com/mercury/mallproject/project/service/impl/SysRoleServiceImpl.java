package com.mercury.mallproject.project.service.impl;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.project.domain.SysRole;
import com.mercury.mallproject.project.domain.SysRoleExample;
import com.mercury.mallproject.project.mapper.SysRoleMapper;
import com.mercury.mallproject.project.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public int save(SysRole sysRole) {
        sysRole.setId(idGenerator.generateId());
        return sysRoleMapper.insert(sysRole);
    }

    @Override
    public List<SysRole> queryAll() {
        SysRoleExample sysRoleExample = new SysRoleExample();
        return sysRoleMapper.selectByExample(sysRoleExample);
    }
}
