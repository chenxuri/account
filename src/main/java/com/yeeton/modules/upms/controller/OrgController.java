package com.yeeton.modules.upms.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.domain.Org;
import com.yeeton.modules.upms.domain.Organization;
import com.yeeton.modules.upms.domain.UserInfo;
import com.yeeton.modules.upms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2017/7/2.
 */
@Controller
@RequestMapping("/upms/org")
public class OrgController {

    @Autowired
    OrgService orgService;

    @Autowired
    UserInfoService userInfoService;

   /* @Autowired
    IndustryService industryService;*/

    @RequestMapping(value = {"","/index"})
    public String index(Model model){
        model.addAttribute("userList",userInfoService.selectOptions());
       // model.addAttribute("industryList",industryService.selectOptions());
        return "/upms/org/list";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageInfo<Org> list(Org org, Integer pageNum, Integer pageSize){
        return orgService.select(org,pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(@RequestBody Org org){
        try {
            Long id =  orgService.add(org);
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
            Integer num = orgService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
