package com.mercury.mallproject.project.service.impl;

import com.google.common.collect.Iterables;
import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.project.domain.SysUser;
import com.mercury.mallproject.project.domain.SysUserExample;
import com.mercury.mallproject.project.mapper.SysUserMapper;
import com.mercury.mallproject.project.service.SysUserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryByUserName(String username) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return Iterables.getFirst(sysUserMapper.selectByExample(sysUserExample), null);
    }

    @Override
    public SysUser queryObject(String userId) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        return Iterables.getFirst(sysUserMapper.selectByExample(sysUserExample), null);
    }

    @Override
    public void save(SysUser user) {
        user.setId(idGenerator.generateId());
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        sysUserMapper.insert(user);
    }

    @Override
    public void updateByUserId(SysUser user) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        sysUserMapper.updateByExample(user, sysUserExample);
    }

    @Override
    public void deleteBatch(List<String> userIds) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserIdIn(userIds);

        sysUserMapper.deleteByExample(sysUserExample);
    }
}
