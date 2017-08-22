package com.yeeton.modules.upms.dao;

import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.upms.domain.Industry;
import com.yeeton.modules.upms.domain.Role;

import java.util.List;

/**
 * Created by user on 2017/7/2.
 */
public interface IndustryDao extends BaseDao<Industry,Long> {

    List<Industry> selectOptions();
}
