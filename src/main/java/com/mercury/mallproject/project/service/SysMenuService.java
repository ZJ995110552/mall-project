package com.mercury.mallproject.project.service;

import com.mercury.mallproject.project.domain.SysMenu;

import java.util.List;

public interface SysMenuService {
    int save(SysMenu sysMenu);

    List<SysMenu> queryAll();
}
