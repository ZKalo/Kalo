package com.kalo.springboot3.shiro;

import com.kalo.springboot3.entity.People;
import com.kalo.springboot3.mapper.PeopleMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Kalo
 * @create 2019-03-25 14:49
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private PeopleMapper mapper;

   /**权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        principalCollection.getPrimaryPrincipal().toString();
        return null;
    }

    /**认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = authenticationToken.getPrincipal().toString();
        People user = mapper.findByName(name);
        if(user==null){
            return null;
        }
        SimpleAuthenticationInfo caInfo = new SimpleAuthenticationInfo(user.getName(),user.getPhone(),getName());
        return caInfo;
    }





//    public static void main(String[] args) {
//        String hashAlgorithmName = "MD5";
//        String credentials = "888888";
//        int hashIterations = 1024;
//        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
//        System.out.println(obj);
//    }

}
