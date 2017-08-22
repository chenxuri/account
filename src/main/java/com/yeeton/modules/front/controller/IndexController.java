package com.yeeton.modules.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2017/7/7.
 */
@Controller
public class IndexController {

    @RequestMapping(value={"","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value={"","/all"})
    public String all(){
        return "front/all";
    }

    @RequestMapping(value={"","/sinablog"})
    public String sinablog(){
        return "front/sinablog";
    }

    @RequestMapping(value={"","/sinaweibo"})
    public String sinaweibo(){
        return "front/sinaweibo";
    }

    @RequestMapping(value={"","/webchat"})
    public String webchat(){
        return "front/webchat";
    }
}
