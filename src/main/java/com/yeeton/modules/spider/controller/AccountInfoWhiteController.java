package com.yeeton.modules.spider.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.spider.domain.AccountInfo;
import com.yeeton.modules.spider.domain.Crawler;
import com.yeeton.modules.spider.service.AccountInfoFindService;
import com.yeeton.modules.spider.service.AccountInfoWhiteService;
import com.yeeton.modules.spider.service.CrawlerService;
import com.yeeton.modules.spider.service.DicService;
import com.yeeton.modules.upms.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2017/6/29.
 */
@Controller
@RequestMapping("/spider/accountInfoWhite")
public class AccountInfoWhiteController {

    @Autowired
    AccountInfoWhiteService accountInfoWhiteService;

    @Autowired
    OrgService orgService;

    @Autowired
    CrawlerService crawlerService;


    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = {"","/index"})
    public String index(Model model){
        model.addAttribute("orgList",orgService.selectOptions());
        model.addAttribute("crawlerList",crawlerService.selectOptions());
        return "/spider/accountInfoWhite/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<AccountInfo> list(AccountInfo accountInfo, Integer pageNum, Integer pageSize){

        System.out.println(accountInfo.getAccountName());
        return accountInfoWhiteService.select(accountInfo,pageNum,pageSize);
    }



    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody AccountInfo accountInfo){
        try {
            Crawler crawlerQuery = new Crawler();
            crawlerQuery.setType(accountInfo.getType());
            Crawler crawlerResult = crawlerService.select(crawlerQuery);

            String accountSetId = "account_"+crawlerResult.getCode()+"_id";

            redisTemplate.opsForSet().add(accountSetId,accountInfo.getAccountId());
            if(crawlerResult != null){
                accountInfo.setAccountType(crawlerResult.getAccountType());
                accountInfo.setAccountTypeName(crawlerResult.getAccountTypeName());
                accountInfo.setTypeName(crawlerResult.getCrawler());
            }
            Long id = accountInfoWhiteService.add(accountInfo);
            if(id != null && id >0){
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
            Integer num = accountInfoWhiteService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
