package com.yeeton.modules.upms.dao;

import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.upms.domain.UserInfo;

import java.util.List;

/**
 * Created by user on 2017/8/11.
 */
public interface UserInfoDao extends BaseDao<UserInfo,String> {

    List<UserInfo> selectOptions();

    Integer checkExists(UserInfo userInfo);

    UserInfo findByUsername(String userName);
}
