package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.PermissionDao;
import com.yeeton.modules.upms.dao.UserDao;
import com.yeeton.modules.upms.domain.Permission;
import com.yeeton.modules.upms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class PermissionService {

    @Autowired
    PermissionDao permissionDao;

    public PageInfo<Permission> select(Permission permission,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Permission> list = permissionDao.select(permission);
        return  new PageInfo<>(list);
    }
}
