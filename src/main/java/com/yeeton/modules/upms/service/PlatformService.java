package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.PlatformDao;
import com.yeeton.modules.upms.dao.UserDao;
import com.yeeton.modules.upms.domain.Log;
import com.yeeton.modules.upms.domain.Platform;
import com.yeeton.modules.upms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class PlatformService {

    @Autowired
    PlatformDao platformDao;

    public PageInfo<Platform> select(Platform platform, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Platform> list = platformDao.select(platform);
        return  new PageInfo<>(list);
    }
}
