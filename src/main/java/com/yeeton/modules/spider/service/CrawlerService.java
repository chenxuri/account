package com.yeeton.modules.spider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.spider.dao.CrawlerDao;
import com.yeeton.modules.spider.domain.Crawler;
import com.yeeton.modules.upms.domain.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
@Service
public class CrawlerService {

    @Autowired
    CrawlerDao crawlerDao;

    public PageInfo<Crawler> select(Crawler crawler, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Crawler> list = crawlerDao.select(crawler);
        return  new PageInfo<>(list);
    }

    public Crawler select(Crawler crawler){
        List<Crawler> list = crawlerDao.select(crawler);
        if (list != null && list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Transient
    public Long add(Crawler crawler){
       return crawlerDao.insert(crawler);
    }

    @Transient
    public Integer delete(Long[] ids){
        return crawlerDao.deleteByPrimaryKeyArray(ids);
    }

    public Crawler selectByPrimaryKey(Long ids){
        return crawlerDao.selectByPrimaryKey(ids);
    }

    @Transient
    public Integer updateCookie(Crawler crawler){
        return crawlerDao.updateCookie(crawler);
    }

    public List<Crawler> selectOptions(){
        return crawlerDao.selectOptions();
    }

}
