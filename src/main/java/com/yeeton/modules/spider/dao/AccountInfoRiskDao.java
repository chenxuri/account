package com.yeeton.modules.spider.dao;


import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.spider.domain.AccountInfo;

import java.util.List;

/**
 * Created by haifeng on 07/02/2017.
 */
public interface AccountInfoRiskDao extends BaseDao<AccountInfo,Long> {

    List<AccountInfo> selectByPrimaryKeys(Long[] idArray);
}
