package com.yeeton;

import com.yeeton.modules.spider.dao.AccountInfoFindDao;
import com.yeeton.modules.spider.domain.AccountInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by user on 2017/7/14.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountInfoTest {

    @Autowired
    AccountInfoFindDao accountInfoDao;

    @Test
    public void testAccountInfo(){

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountName("微信");
        List<AccountInfo> accountInfoList = accountInfoDao.select(accountInfo);
        System.out.println(accountInfoList.size());
    }
}
