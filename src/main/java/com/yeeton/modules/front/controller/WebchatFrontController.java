package com.yeeton.modules.front.controller;

import com.yeeton.modules.front.domain.Kv;
import com.yeeton.modules.upms.domain.Organization;
import com.yeeton.modules.upms.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by user on 2017/7/7.
 */
@RestController
@RequestMapping("/front/webchat")
public class WebchatFrontController {

    @Autowired
    OrganizationService organizationService;

    @RequestMapping("/bubbles")
    public Map<String,Object> Bubbles(){

        List<Organization> organizationList = organizationService.selectOptions();
        List<Kv> kvList = new ArrayList<>();
        Random random = new Random();
        for (Organization organization : organizationList) {
            kvList.add(new Kv(organization.getName(), random.nextInt(1000)));
        }
        Map<String,Object> map= new HashMap<>();
        map.put("data",kvList);
        map.put("reCode",0);
        return map;
    }
}
