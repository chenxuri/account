package com.yeeton.modules.upms.dao;

import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.upms.domain.User;

import java.util.List;

/**
 * Created by user on 2017/7/2.
 */
public interface UserDao extends BaseDao<User,Long> {

    List<User> selectOptions();

    Integer checkExists(User user);

    User findByUsername(String userName);
}
