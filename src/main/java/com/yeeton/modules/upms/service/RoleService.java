package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.RoleDao;
import com.yeeton.modules.upms.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public PageInfo<Role> select(Role role, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Role> list = roleDao.select(role);
        return  new PageInfo<>(list);
    }


    @Transient
    public Integer update(Role role){
        return  roleDao.updateByPrimaryKey(role);
    }

    @Transient
    public Integer delete(Long[] ids){
        return  roleDao.deleteByPrimaryKeyArray(ids);
    }
}
