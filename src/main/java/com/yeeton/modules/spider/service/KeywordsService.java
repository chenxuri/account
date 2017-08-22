package com.yeeton.modules.spider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.spider.dao.KeywordsDao;
import com.yeeton.modules.spider.domain.Keywords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
@Service
public class KeywordsService {

    @Autowired
    KeywordsDao keywordsDao;

    public PageInfo<Keywords> select(Keywords keywords, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Keywords> list = keywordsDao.select(keywords);
        return  new PageInfo<>(list);
    }

    @Transient
    public Long add(Keywords keywords){
       return keywordsDao.insert(keywords);
    }

    @Transient
    public Integer delete(Long[] ids){
        return keywordsDao.deleteByPrimaryKeyArray(ids);
    }
}
