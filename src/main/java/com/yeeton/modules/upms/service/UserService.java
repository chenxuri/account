package com.yeeton.modules.upms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.upms.dao.UserDao;
import com.yeeton.modules.upms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/27.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public PageInfo<User>  select(User user, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userDao.select(user);
        return  new PageInfo<>(list);
    }

    public List<User> selectOptions(){
        return userDao.selectOptions();
    }

    public User findByUsername(String userName){
        return userDao.findByUsername(userName);
    }

    public Boolean checkExists(User user){
        if(userDao.checkExists(user) > 0){
            return false;
        }
        return true;
    }

    @Transient
    public Long add(User user){
        return  userDao.insert(user);
    }

    @Transient
    public Integer update(User user){
        return  userDao.updateByPrimaryKey(user);
    }

    @Transient
    public Integer delete(Long[] ids){
        return  userDao.deleteByPrimaryKeyArray(ids);
    }
}
