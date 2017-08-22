package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.OrgDao;
import com.yeeton.modules.upms.dao.UserDao;
import com.yeeton.modules.upms.dao.UserInfoDao;
import com.yeeton.modules.upms.domain.Org;
import com.yeeton.modules.upms.domain.User;
import com.yeeton.modules.upms.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    public PageInfo<UserInfo>  select(UserInfo user, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> list = userInfoDao.select(user);
        return  new PageInfo<>(list);
    }

    public List<UserInfo> selectOptions(){
        return userInfoDao.selectOptions();
    }

    public UserInfo findByUsername(String userName){
        return userInfoDao.findByUsername(userName);
    }

    public Boolean checkExists(UserInfo userInfo){
        if(userInfoDao.checkExists(userInfo) > 0){
            return false;
        }
        return true;
    }

    @Transient
    public String add(UserInfo userInfo){
        return  userInfoDao.insert(userInfo);
    }

    @Transient
    public Integer update(UserInfo userInfo){
        return  userInfoDao.updateByPrimaryKey(userInfo);
    }

    @Transient
    public Integer delete(String[] ids){
        return  userInfoDao.deleteByPrimaryKeyArray(ids);
    }
}
