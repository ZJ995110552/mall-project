package com.mercury.mallproject.project.service.impl;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.project.domain.SysRoleMenu;
import com.mercury.mallproject.project.mapper.SysRoleMenuMapper;
import com.mercury.mallproject.project.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int save(SysRoleMenu sysRoleMenu) {
        sysRoleMenu.setId(idGenerator.generateId());
        return sysRoleMenuMapper.insert(sysRoleMenu);
    }
}
