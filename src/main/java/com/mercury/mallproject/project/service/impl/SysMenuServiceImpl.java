package com.mercury.mallproject.project.service.impl;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.project.domain.SysMenu;
import com.mercury.mallproject.project.domain.SysMenuExample;
import com.mercury.mallproject.project.mapper.SysMenuMapper;
import com.mercury.mallproject.project.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int save(SysMenu sysMenu) {
        sysMenu.setId(idGenerator.generateId());
        return sysMenuMapper.insert(sysMenu);
    }

    @Override
    public List<SysMenu> queryAll() {
        SysMenuExample sysMenuExample = new SysMenuExample();
        return sysMenuMapper.selectByExample(sysMenuExample);
    }
}
