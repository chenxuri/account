package com.yeeton.modules.spider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yeeton.common.base.BaseEntity;
import com.yeeton.modules.upms.domain.Organization;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by user on 2017/7/12.
 */
public class AccountInfo extends BaseEntity<Long> {

  /*    `_id` bigint(20) NOT NULL,
        `icon` varchar(255) DEFAULT NULL COMMENT '图标',
        `image` varchar(255) DEFAULT NULL COMMENT '第二图标',
        `url` varchar(255) NOT NULL COMMENT '访问地址',
        `account_id` varchar(50) NOT NULL COMMENT '账号',
        `account_name` varchar(255) NOT NULL COMMENT '账号名称',
        `account_type` int(10) NOT NULL COMMENT '账号类型',
        `account_type_name` varchar(255) NOT NULL COMMENT '账号类型名称',
        `org_id` bigint(20) NOT NULL COMMENT '所属机构ID',
        `org_name` varchar(255) NOT NULL COMMENT '所属机构名称',
        `keywords` varchar(255) NOT NULL COMMENT '搜索的关键词',
        `labels` varchar(255) DEFAULT NULL COMMENT '标签',
        `renzhen` varchar(255) DEFAULT NULL COMMENT '认证信息',
        `describe` varchar(255) DEFAULT NULL COMMENT '描述',
        `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0未处置 1风险 2 官方 3 诈骗 ',
        `create_time` datetime DEFAULT NULL COMMENT '添加时间',*/


    private String icon;                    //图标
    private String image;                   //第二图标
    private String url;                     //访问地址
    private String accountId;               //账号ID
    private String accountName;             //账号名称
    private Integer accountType;             //账号类型
    private String accountTypeName;         //账号类型名称
    private String nickname;         //账号类型名称
    private String imagePath;         //账号类型名称
    private Integer type;         //类型
    private String  typeName;         //类型名称
    private Organization organization;
    private String orgName;  //机构名称 查询用
    private String keywords;                //搜索的关键词
    private String labels;                  //标签
    private String renzhen;                 //认证信息
    private String remarks;                //描述
    private Integer status;                  //状态
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss" )
    private Date checkTime;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getRenzhen() {
        return renzhen;
    }

    public void setRenzhen(String renzhen) {
        this.renzhen = renzhen;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}
