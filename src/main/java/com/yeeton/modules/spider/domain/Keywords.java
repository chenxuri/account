package com.yeeton.modules.spider.domain;

import com.yeeton.common.base.BaseEntity;
import com.yeeton.modules.upms.domain.Organization;

/**
 * Created by user on 2017/7/3.
 */
public class Keywords extends BaseEntity<Long> {

    private Organization organization;

    /**
     * 关键词
     */
    private String keywords;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
