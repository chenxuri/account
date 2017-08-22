package com.yeeton.modules.spider.dao;

import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.spider.domain.Dic;

import java.util.List;

/**
 * Created by haifeng on 2017/7/12.
 */
public interface DicDao extends BaseDao<Dic,Long> {

    Integer updateCookie(Dic dic);

    List<Dic> selectOptions(Long pid);
}
