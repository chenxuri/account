package com.yeeton.modules.spider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.spider.dao.CrawlerDao;
import com.yeeton.modules.spider.dao.DicDao;
import com.yeeton.modules.spider.domain.Crawler;
import com.yeeton.modules.spider.domain.Dic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
@Service
public class DicService {

    @Autowired
    DicDao dicDao;

    public PageInfo<Dic> select(Dic dic, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Dic> list = dicDao.select(dic);
        return  new PageInfo<>(list);
    }

    @Transient
    public Long add(Dic dic){
       return dicDao.insert(dic);
    }

    @Transient
    public Integer delete(Long[] ids){
        return dicDao.deleteByPrimaryKeyArray(ids);
    }

    public Dic selectByPrimaryKey(Long ids){
        return dicDao.selectByPrimaryKey(ids);
    }

    @Transient
    public Integer updateCookie(Dic dic){
        return dicDao.updateCookie(dic);
    }

    public List<Dic> selectOptions(Long pid){
        return dicDao.selectOptions(pid);
    }

}
