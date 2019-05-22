package com.mercury.mallproject.service.api;

import com.mercury.mallproject.domain.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 根据用户名，查询系统用户
     */
    SysUser queryByUserName(String username);

    /**
     * 根据用户ID，查询用户
     * @param userId
     * @return
     */
    SysUser queryObject(String userId);

    /**
     * 保存用户
     */
    void save(SysUser user);

    /**
     * 修改用户
     */
    void updateByUserId(SysUser user);

    /**
     * 删除用户
     */
    void deleteBatch(List<String> userIds);


}
