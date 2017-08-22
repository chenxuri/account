package com.yeeton.common.config.shiro;

import com.yeeton.common.util.Digests;
import com.yeeton.common.util.Encodes;
import com.yeeton.modules.upms.domain.User;
import com.yeeton.modules.upms.domain.UserInfo;
import com.yeeton.modules.upms.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Resource
    private UserInfoService userInfoService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        /*
            for(SysRole role:userInfo.getRoleList()){
                authorizationInfo.addRole(role.getRole());
                for(SysPermission p:role.getPermissions()){
                    authorizationInfo.addStringPermission(p.getPermission());
                }
            }
        */
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {


        // 1. 把AuthenticationToken 转换为UsernamePasswordToken
        UsernamePasswordToken up = (UsernamePasswordToken) token;
        // 2. 从UsernamePasswordToken 中来获取username
        String username = up.getUsername();
        char[] password = up.getPassword();
        // 3. 调用数据库的方法，从数据库中查询username对应的用户记录
        System.out.println("从数据库中获取userName ：" + username + " 所对应的用户信息.");
        // 4. 若用户不存在，则可以抛出 UnknownAccoountException 异常
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在");
        }
        // 5. 根据用户信息的情况，决定是否需要抛出其他的AuthencationException 异常 假设用户被锁定
        if ("monster".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }
        // 6. 根据用户的情况，来构建AuthenticationInfo 对象并返回，通常使用的是
        // SimpleAuthenticationInfo
        // 以下信息是从数据库获取的.

        Object principal = username; // principal 认证的实体信息.
        // 可以是username，也可以是数据表对应的用户的实体类对象
//        String credentials = "fc1709d0a95a6be30bc5926fdb7f22f4"; // credentials：密码
        AuthenticationInfo info = null;//*new SimpleAuthenticationInfo(principal, credentials, realmName);*//*



        UserInfo user = userInfoService.findByUsername(username);
        if (user != null) {

            byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
            return new SimpleAuthenticationInfo(username,
                    user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
        } else {
            return null;
        }

    }

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
    }


    public static void main(String[] args){
       // String psw = entryptPassword("admin");
        System.out.println(validatePassword("d6a33a2456338a88acec133487d38ccf163abb4575b368b074e327ee","admin"));
    }
    /**
     * 验证密码
     * @param plainPassword 明文密码
     * @param password 密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        byte[] salt = Encodes.decodeHex(password.substring(0,8));
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }

    /* System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
    //获取用户的输入的账号.
    String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
    //通过username从数据库中查找 User对象，如果找到，没找到.
    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
    User user = userService.findByUsername(username);
        System.out.println("----->>user = "+user);
        if(user == null){
        return null;
    }
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            user, //用户名
            user.getPassword(), //密码
            ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
            getName()  //realm name
    );
        return authenticationInfo;*/

   /*


*/


}