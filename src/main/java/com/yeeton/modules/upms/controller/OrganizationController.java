package com.yeeton.modules.upms.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.domain.Organization;
import com.yeeton.modules.upms.domain.User;
import com.yeeton.modules.upms.service.IndustryService;
import com.yeeton.modules.upms.service.OrganizationService;
import com.yeeton.modules.upms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017/7/2.
 */
@Controller
@RequestMapping("/org")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    UserService userService;

    @Autowired
    IndustryService industryService;

    @RequestMapping(value = {"","/index"})
    public String index(Model model){
        model.addAttribute("userList",userService.selectOptions());
        model.addAttribute("industryList",industryService.selectOptions());
        return "/upms/org/list";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageInfo<Organization> list(Organization organization, Integer pageNum, Integer pageSize){
        return organizationService.select(organization,pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(@RequestBody Organization organization){
        try {
            Long id =  organizationService.add(organization);
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
            Integer num = organizationService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
