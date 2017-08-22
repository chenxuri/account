package com.yeeton.modules.spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2017/6/30.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/list")
    public String list(){
        return "/spider/webChat/list";
    }
}
