package com.yeeton.modules.upms.dao;

import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.upms.domain.Organization;

import java.util.List;

/**
 * Created by user on 2017/7/2.
 */
public interface OrganizationDao extends BaseDao<Organization,Long> {

    List<Organization> selectOptions();
}
