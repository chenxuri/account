package com.yeeton.modules.upms.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.domain.UserInfo;
import com.yeeton.modules.upms.service.OrgService;
import com.yeeton.modules.upms.service.OrganizationService;
import com.yeeton.modules.upms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2017/6/27.
 */
@Controller
@RequestMapping("/upms/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    OrgService orgService;

    @RequestMapping(value = {"","index"})
    public String index(Model model){
        model.addAttribute("orgList",orgService.selectOptions());
        return "/upms/user/list";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageInfo<UserInfo> list(UserInfo userInfo, Integer pageNum, Integer pageSize){
        return userInfoService.select(userInfo,pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "user_exists",method = RequestMethod.POST)
    public Boolean checkExists(UserInfo userInfo){
        return userInfoService.checkExists(userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(@RequestBody UserInfo userInfo){
        try {
            String id =  userInfoService.add(userInfo);
            if(id != null ){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam("ids") String[] ids){
        System.out.println(ids);
        try {
            Integer num = userInfoService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
