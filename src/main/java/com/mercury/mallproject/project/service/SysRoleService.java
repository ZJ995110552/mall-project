package com.mercury.mallproject.project.service;

import com.mercury.mallproject.project.domain.SysRole;

import java.util.List;

public interface SysRoleService {
    int save(SysRole sysRole);

    List<SysRole> queryAll();
}
