package com.yeeton;

import com.xiaoleilu.hutool.util.RandomUtil;
import com.yeeton.modules.upms.domain.User;
import com.yeeton.modules.upms.service.UserService;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Created by user on 2017/8/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){

        try {
           String rs =  RandomUtil.randomString(6);
            System.out.println(rs);
            String code = new  Sha256Hash("12345678",rs).toString();
            System.out.println(code);
            System.out.println(ByteSource.Util.bytes("12345678"));
            User user = new User();
            user.setUsername("admin");
            user.setSalt(rs);
            user.setPassword(code);
            userService.add(user);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
