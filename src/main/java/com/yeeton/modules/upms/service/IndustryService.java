package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.AreaDao;
import com.yeeton.modules.upms.dao.IndustryDao;
import com.yeeton.modules.upms.domain.Area;
import com.yeeton.modules.upms.domain.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class IndustryService {

    @Autowired
    IndustryDao industryDao;

    public PageInfo<Industry> select(Industry industry, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Industry> list = industryDao.select(industry);
        return  new PageInfo<>(list);
    }


    public List<Industry> selectOptions(){
        return industryDao.selectOptions();
    }
}
