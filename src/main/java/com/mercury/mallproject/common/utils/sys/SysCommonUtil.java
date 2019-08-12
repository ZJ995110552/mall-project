package com.mercury.mallproject.common.utils.sys;

import com.mercury.mallproject.common.constant.ShiroConstants;
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
        return (SysUser) session.getAttribute(ShiroConstants.CURRENT_USER);
    }

}
