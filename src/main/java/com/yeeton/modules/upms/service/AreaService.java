package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.AreaDao;
import com.yeeton.modules.upms.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class AreaService {

    @Autowired
    AreaDao areaDao;

    public PageInfo<Area> select(Area area,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Area> list = areaDao.select(area);
        return  new PageInfo<>(list);
    }
}
