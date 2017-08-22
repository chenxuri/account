package com.yeeton.modules.spider.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.common.config.amqp.AmqpConstant;
import com.yeeton.common.config.amqp.CrawlerMessage;
import com.yeeton.modules.spider.domain.Crawler;
import com.yeeton.modules.spider.service.CrawlerService;
import com.yeeton.modules.spider.service.DicService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by user on 2017/6/29.
 */
@Controller
@RequestMapping("/spider/crawler")
public class CrawlerController {

    @Autowired
    CrawlerService crawlerService;


    @Autowired
    DicService dicService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping(value = {"","/index"})
    public String index(Model model){
        model.addAttribute("crawlerTypeList",dicService.selectOptions(1l));
        return "/spider/crawler/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Crawler> list(Crawler crawler, Integer pageNum, Integer pageSize){
        System.out.println(crawler.getCrawler());
        return crawlerService.select(crawler,pageNum,pageSize);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Crawler crawler){
        try {
            Long id = crawlerService.add(crawler);
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
            Integer num = crawlerService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping(value = "/start",method = RequestMethod.POST)
    @ResponseBody
    public String start(@RequestParam("id") Long id){
       /* this.rabbitTemplate.convertAndSend("crawler", "webchat.message", "start");*/

        CrawlerMessage crawlerMessage = new CrawlerMessage();
        crawlerMessage.setCode("start");
        crawlerMessage.setCrawlerId(id);
        Crawler crawler = crawlerService.selectByPrimaryKey(id);
        // for (Crawler crawler : crawlerDao.selectAll()) {
        this.rabbitTemplate.convertAndSend(AmqpConstant.exchange,"message."+crawler.getCode(), crawlerMessage);
        // }

        return "0";
    }

    @RequestMapping(value = "/stop",method = RequestMethod.POST)
    @ResponseBody
    public String stop(@RequestParam("id") Long id){
        System.out.println(id);
        /*try {
            Integer num = crawlerService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        this.rabbitTemplate.convertAndSend("crawler", "webchat.message", "stop");
        return "0";
    }


    @RequestMapping(value = "/modifyCookie",method = RequestMethod.POST)
    @ResponseBody
    public String start(@RequestBody Crawler crawler){
        crawlerService.updateCookie(crawler);
        return "1";
    }

}
