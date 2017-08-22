package com.yeeton.modules.spider.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.spider.domain.AccountInfo;
import com.yeeton.modules.spider.service.AccountInfoFindService;
import com.yeeton.modules.spider.service.AccountInfoRiskService;
import com.yeeton.modules.spider.service.AccountInfoWhiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
@Controller
@RequestMapping("/spider/accountInfoFind")
public class AccountInfoFindController {

    @Autowired
    AccountInfoFindService accountInfoFindService;

    @Autowired
    AccountInfoWhiteService accountInfoWhiteService;

    @Autowired
    AccountInfoRiskService accountInfoRiskService;


    @RequestMapping(value = {"","/index"})
    public String index(){
        return "/spider/accountInfoFind/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<AccountInfo> list(AccountInfo accountInfo, Integer pageNum, Integer pageSize){

        System.out.println(accountInfo.getAccountName());
        return accountInfoFindService.select(accountInfo,pageNum,pageSize);
    }



    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam("ids") Long[] ids){
        System.out.println(ids);
        try {
            Integer num = accountInfoFindService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }



    @RequestMapping(value = "/white",method = RequestMethod.POST)
    @ResponseBody
    public String white(@RequestParam("ids") Long[] ids){
        System.out.println(ids);

        try {

            List<AccountInfo> accountInfoList = accountInfoFindService.selectByPrimaryKeys(ids);
            Integer idArray = accountInfoWhiteService.batchAdd(accountInfoList);
            accountInfoFindService.delete(ids);
            if(idArray != null && idArray >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping(value = "/risk",method = RequestMethod.POST)
    @ResponseBody
    public String risk(@RequestParam("ids") Long[] ids){
        System.out.println(ids);
        try {

            List<AccountInfo> accountInfoList = accountInfoFindService.selectByPrimaryKeys(ids);
            Date now = new Date();
            accountInfoList.forEach(e ->{
                e.setCheckTime(now);
            });
            Integer idArray = accountInfoRiskService.batchAdd(accountInfoList);
            accountInfoFindService.delete(ids);
            if(idArray != null && idArray  >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
