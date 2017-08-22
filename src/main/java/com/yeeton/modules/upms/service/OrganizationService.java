package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.OrganizationDao;
import com.yeeton.modules.upms.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationDao organizationDao;

    public PageInfo<Organization> select(Organization organization,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Organization> list = organizationDao.select(organization);
        return  new PageInfo<>(list);
    }

    @Transient
    public Long add(Organization organization){
        return  organizationDao.insert(organization);
    }

    @Transient
    public Integer update(Organization organization){
        return  organizationDao.updateByPrimaryKey(organization);
    }

    @Transient
    public Integer delete(Long[] ids){
        return  organizationDao.deleteByPrimaryKeyArray(ids);
    }

    public List<Organization> selectOptions(){
       return organizationDao.selectOptions();
    }
}
