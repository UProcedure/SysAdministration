package com.qf.oa.realm;

import com.qf.oa.entity.SysMenu;
import com.qf.oa.entity.SysUser;
import com.qf.oa.service.ISysMenuService;
import com.qf.oa.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @Description TODO
 * @author weimin
 * @date 2019/9/29 16:25
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权处理。。。");
        Set<String> set = new HashSet<>();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        List<SysMenu> menus = sysUserService.getUserMenu(sysUser.getUserId());
        for (SysMenu menu : menus) {
            if(menu.getMenuType()==3){
                set.add(menu.getMenuPath());
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(set);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        SysUser user = sysUserService.getUserByUserName(username);
        if(user!=null){
            ByteSource source = ByteSource.Util.bytes(username);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getUserPassword(),source,this.getName());
            return authenticationInfo;
        }
        return null;

    }
}
