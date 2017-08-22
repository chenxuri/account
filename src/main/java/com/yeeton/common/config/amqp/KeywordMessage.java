package com.yeeton.common.config.amqp;

import java.io.Serializable;

/**
 * Created by user on 2017/7/11.
 */
public class KeywordMessage implements Serializable{

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构ID
     */
    private Long orgId;

    /**
     * 关键词
     */
    private String keywords;

    public KeywordMessage() {
    }

    public KeywordMessage(String orgName, Long orgId, String keywords) {
        this.orgName = orgName;
        this.orgId = orgId;
        this.keywords = keywords;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "KeywordMessage{" +
                "orgName='" + orgName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
