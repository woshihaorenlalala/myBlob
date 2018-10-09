package com.blob.module.common.shrio;

import com.blob.module.sys.entity.User;
import com.blob.module.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/10/8.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();

        user.getRoles().forEach( r -> {
            simpleAuthorizationInfo.addRole(r.getRole());
            r.getPermissions().forEach(p -> {
                simpleAuthorizationInfo.addStringPermission(p.getPermission());
            });
        });
        return simpleAuthorizationInfo;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        if(authenticationToken.getPrincipal() == null){
            return null;
        }
        String name = authenticationToken.getPrincipal().toString();
        User user = userService.findByUsername(name);

        if(user == null){
            return null;
        }else{
            //参数分别是用户名、密码、加密方式、realm name
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name,
                    user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
             return simpleAuthenticationInfo;
        }
    }

}
