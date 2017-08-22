package com.yeeton.modules.upms.controller;

import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.domain.Area;
import com.yeeton.modules.upms.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2017/7/2.
 */
@Controller
@RequestMapping("/upms/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    @RequestMapping(value = {"","/index"})
    public String index(){
        return "/upms/area/list";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageInfo<Area> list(Area area,Integer pageNum,Integer pageSize){
        return areaService.select(area,pageNum,pageSize);
    }
}
