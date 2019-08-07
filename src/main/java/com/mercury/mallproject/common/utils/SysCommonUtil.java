package com.mercury.mallproject.common.utils;

import com.mercury.mallproject.common.constant.SysConst;
import com.mercury.mallproject.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class SysCommonUtil {

    /**
     * 获取当前用户
     */
    public static SysUser getUser() {
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return (SysUser) session.getAttribute(SysConst.SYS_CURRENT_USER_KEY);
    }

}
