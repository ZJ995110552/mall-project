package com.mercury.mallproject.shiro.utils;


import com.mercury.mallproject.common.utils.StringUtils;
import com.mercury.mallproject.common.utils.bean.BeanUtils;
import com.mercury.mallproject.project.domain.SysUser;
import com.mercury.mallproject.shiro.realm.AuthRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * shiro 工具类
 */
public class ShiroUtils
{
    public static Subject getSubjct()
    {
        return SecurityUtils.getSubject();
    }

    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout()
    {
        getSubjct().logout();
    }

    public static SysUser getSysUser()
    {
        SysUser sysUser = null;
        Object obj = getSubjct().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
            sysUser = new SysUser();
            BeanUtils.copyBeanProp(sysUser, obj);
        }
        return sysUser;
    }

    public static void setSysUser(SysUser user)
    {
        Subject subject = getSubjct();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    public static void clearCachedAuthorizationInfo()
    {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        AuthRealm realm = (AuthRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }

    public static String getUserId()
    {
        return getSysUser().getUserId();
    }

    public static String getLoginName()
    {
        return getSysUser().getUsername();
    }

    public static String getIp()
    {
        return getSubjct().getSession().getHost();
    }

    public static String getSessionId()
    {
        return String.valueOf(getSubjct().getSession().getId());
    }
}
