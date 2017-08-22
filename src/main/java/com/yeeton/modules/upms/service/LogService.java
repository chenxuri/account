package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.LogDao;
import com.yeeton.modules.upms.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class LogService {

    @Autowired
    LogDao logDao;

    public PageInfo<Log> select(Log log,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Log> list = logDao.select(log);
        return  new PageInfo<>(list);
    }
}
