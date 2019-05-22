package com.mercury.mallproject.service.impl;

import com.mercury.mallproject.domain.SysUser;
import com.mercury.mallproject.domain.SysUserExample;
import com.mercury.mallproject.repository.mapper.SysUserMapper;
import com.mercury.mallproject.service.api.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryByUserName(String username) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();

        criteria.andUsernameEqualTo(username);
        return null;

    }

    @Override
    public SysUser queryObject(String userId) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();

        criteria.andUsernameEqualTo(userId);

        return null;
    }

    @Override
    public void save(SysUser user) {
        sysUserMapper.insert(user);

    }

    @Override
    public void updateByUserId(SysUser user) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();

        criteria.andUserIdEqualTo(user.getUserId());

        sysUserMapper.updateByExample(user,sysUserExample);

    }

    @Override
    public void deleteBatch(List<String> userIds) {

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserIdIn(userIds);

        sysUserMapper.deleteByExample(sysUserExample);

    }
}
