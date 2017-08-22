package com.yeeton.modules.spider.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.common.config.amqp.KeywordMessage;
import com.yeeton.modules.spider.domain.AccountInfo;
import com.yeeton.modules.spider.domain.Keywords;
import com.yeeton.modules.spider.service.AccountInfoFindService;
import com.yeeton.modules.spider.service.AccountInfoRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
@Controller
@RequestMapping("/spider/accountInfoRisk")
public class AccountInfoRiskController {

    @Autowired
    AccountInfoRiskService accountInfoRiskService;


    @Autowired
    AccountInfoFindService accountInfoFindService;


    @RequestMapping(value = {"","/index"})
    public String index(){
        return "/spider/accountInfoRisk/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<AccountInfo> list(AccountInfo accountInfo, Integer pageNum, Integer pageSize){

        System.out.println(accountInfo.getAccountName());
        return accountInfoRiskService.select(accountInfo,pageNum,pageSize);
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody AccountInfo accountInfo){
        try {
            Long id = accountInfoRiskService.add(accountInfo);
            if(id != null && id >0){
               /* KeywordMessage keywordMessage = new KeywordMessage(keywords.getOrganization().getName(),id,keywords.getKeywords());
                this.accountInfoRiskService.convertSendAndReceive("keywordFanoutExchange","", keywordMessage);*/
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam("ids") Long[] ids){
        System.out.println(ids);
        try {
            Integer num = accountInfoRiskService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }


    @RequestMapping(value = "/checkBack",method = RequestMethod.POST)
    @ResponseBody
    public String back(@RequestParam("ids") Long[] ids){
        System.out.println(ids);
        try {

            List<AccountInfo> accountInfoList = accountInfoRiskService.selectByPrimaryKeys(ids);
            Date now = new Date();
            accountInfoList.forEach(e ->{
                e.setCheckTime(now);
            });
            Integer idArray = accountInfoFindService.batchAdd(accountInfoList);
            accountInfoRiskService.delete(ids);
            if(idArray != null && idArray >0){
                return "1";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

}
