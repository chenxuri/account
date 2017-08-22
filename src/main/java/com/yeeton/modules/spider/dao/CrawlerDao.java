package com.yeeton.modules.spider.dao;

import com.yeeton.common.base.BaseDao;
import com.yeeton.modules.spider.domain.Crawler;

import java.util.List;

/**
 * Created by haifeng on 2017/7/12.
 */
public interface CrawlerDao  extends BaseDao<Crawler,Long> {

    Integer updateCookie(Crawler crawler);

    List<Crawler> selectOptions();
}
