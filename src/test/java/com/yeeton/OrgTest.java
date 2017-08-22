package com.yeeton;

import com.yeeton.modules.spider.service.DicService;
import com.yeeton.modules.upms.domain.Org;
import com.yeeton.modules.upms.service.OrgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by user on 2017/8/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgTest {

    @Autowired
    OrgService orgService;

    @Autowired
    DicService dicService;

    @Test
    public void test(){

        System.out.println("dicService: "+dicService.selectOptions(1l));

        /*try {
          List<Org> orgList = orgService.selectOptions();

            for (Org org : orgList) {
                System.out.println(org.getName());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
*/
    }
}
