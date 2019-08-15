package com.mercury.mallproject.shiro.realm;

import com.mercury.mallproject.project.domain.SysMenu;
import com.mercury.mallproject.project.domain.SysMenuExample;
import com.mercury.mallproject.project.domain.SysUser;
import com.mercury.mallproject.project.domain.SysUserExample;
import com.mercury.mallproject.project.mapper.SysMenuMapper;
import com.mercury.mallproject.project.mapper.SysUserMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 认证
 */
public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysMenuMapper sysMenuMapper;

    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();
		String userId = sysUser.getUserId();

		List<String> permsList = null;
		
		//系统管理员，拥有最高权限
		if("1908002".equals(userId)){
			SysMenuExample sysMenuExample = new SysMenuExample();
			List<SysMenu> sysMenus = sysMenuMapper.selectByExample(sysMenuExample);

			permsList = new ArrayList<>(sysMenus.size());
			for (SysMenu menu: sysMenus) {
				permsList.add(menu.getPermissions());
			}

		}else{
			permsList = sysUserMapper.queryAllPermissions(sysUser.getUserId());
		}

		//用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        //查询用户信息
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		SysUser sysUser = sysUserMapper.selectByExample(sysUserExample).stream().findFirst().get();

		//账号不存在
        if(sysUser == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        
        //密码错误
        if(!password.equals(sysUser.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        
        //账号锁定
        if(sysUser.getStatus() == null || sysUser.getStatus() == 0){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, password, getName());
        return info;
	}

	/**
	 * 清理缓存权限
	 */
	public void clearCachedAuthorizationInfo()
	{
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}

}
