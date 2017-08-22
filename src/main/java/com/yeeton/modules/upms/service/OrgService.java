package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.OrgDao;
import com.yeeton.modules.upms.domain.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class OrgService {

    @Autowired
    OrgDao orgDao;
    public PageInfo<Org> select(Org org, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Org> list = orgDao.select(org);
        return  new PageInfo<>(list);
    }

    @Transient
    public Long add(Org org){
        return  orgDao.insert(org);
    }

    @Transient
    public Integer update(Org org){
        return  orgDao.updateByPrimaryKey(org);
    }

    @Transient
    public Integer delete(Long[] ids){
        return  orgDao.deleteByPrimaryKeyArray(ids);
    }

    public List<Org> selectOptions(){
       return orgDao.selectOptions();
    }
}
