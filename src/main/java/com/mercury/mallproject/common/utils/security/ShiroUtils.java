package com.mercury.mallproject.common.utils.security;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * shiro 工具类
 * 
 * @author ruoyi
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

//    public static User getSysUser()
//    {
//        User user = null;
//        Object obj = getSubjct().getPrincipal();
//        if (StringUtils.isNotNull(obj))
//        {
//            user = new User();
//            BeanUtils.copyBeanProp(user, obj);
//        }
//        return user;
//    }
//
//    public static void setSysUser(User user)
//    {
//        Subject subject = getSubjct();
//        PrincipalCollection principalCollection = subject.getPrincipals();
//        String realmName = principalCollection.getRealmNames().iterator().next();
//        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
//        // 重新加载Principal
//        subject.runAs(newPrincipalCollection);
//    }
//
//    public static void clearCachedAuthorizationInfo()
//    {
//        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
//        UserRealm realm = (UserRealm) rsm.getRealms().iterator().next();
//        realm.clearCachedAuthorizationInfo();
//    }
//
//    public static Long getUserId()
//    {
//        return getSysUser().getUserId().longValue();
//    }
//
//    public static String getLoginName()
//    {
//        return getSysUser().getLoginName();
//    }
//
//    public static String getIp()
//    {
//        return getSubjct().getSession().getHost();
//    }
//
//    public static String getSessionId()
//    {
//        return String.valueOf(getSubjct().getSession().getId());
//    }
}
