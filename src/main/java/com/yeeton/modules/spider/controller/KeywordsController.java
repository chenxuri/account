package com.yeeton.modules.spider.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.common.config.amqp.KeywordMessage;
import com.yeeton.modules.spider.domain.Keywords;
import com.yeeton.modules.spider.service.KeywordsService;
import com.yeeton.modules.upms.service.OrgService;
import com.yeeton.modules.upms.service.OrganizationService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2017/7/2.
 */
@Controller
@RequestMapping("/spider/keywords")
public class KeywordsController {

    @Autowired
    KeywordsService keywordsService;

    @Autowired
    OrgService orgService;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("orgList",orgService.selectOptions());
        return "/spider/keywords/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Keywords> list(Keywords keywords, Integer pageNum, Integer pageSize){
        return keywordsService.select(keywords,pageNum,pageSize);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Keywords keywords){
        try {
            Long id = keywordsService.add(keywords);
            if(id != null && id >0){
                KeywordMessage keywordMessage = new KeywordMessage(keywords.getOrganization().getName(),id,keywords.getKeywords());
                this.rabbitTemplate.convertSendAndReceive("keywordFanoutExchange","", keywordMessage);
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
            Integer num = keywordsService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }





}
