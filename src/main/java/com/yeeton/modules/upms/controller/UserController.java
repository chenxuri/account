package com.yeeton.modules.upms.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.domain.User;
import com.yeeton.modules.upms.service.OrganizationService;
import com.yeeton.modules.upms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2017/6/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = {"","index"})
    public String index(Model model){
        model.addAttribute("orgList",organizationService.selectOptions());
        return "/upms/user/list";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageInfo<User> list(User user,Integer pageNum,Integer pageSize){
        return userService.select(user,pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "user_exists",method = RequestMethod.POST)
    public Boolean checkExists(User user){
        return userService.checkExists(user);
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(@RequestBody User user){
        try {
            Long id =  userService.add(user);
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
            Integer num = userService.delete(ids);
            if(num != null && num >0){
                return "1";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
