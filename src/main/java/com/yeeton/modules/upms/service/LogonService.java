package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.LogonDao;
import com.yeeton.modules.upms.domain.Area;
import com.yeeton.modules.upms.domain.Logon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class LogonService {

    @Autowired
    LogonDao logonDao;

    public PageInfo<Logon> select(Logon logon, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Logon> list = logonDao.select(logon);
        return  new PageInfo<>(list);
    }
}
