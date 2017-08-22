package com.yeeton.modules.spider.domain;

import com.yeeton.common.base.BaseEntity;

/**
 * Created by user on 2017/7/12.
 */
public class Crawler extends BaseEntity<Long> {


   /*
        `_id` bigint(11) NOT NULL AUTO_INCREMENT,
        `crawler` varchar(255) NOT NULL COMMENT '网址名称',
        `cookie` varchar(1024) DEFAULT NULL COMMENT 'cookie值',
        `type` int(5) NOT NULL COMMENT '类型:1 搜狗微信cookie',
        `count` bigint(20) DEFAULT NULL COMMENT '数据数量',
        `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
        `status` tinyint(4) DEFAULT NULL COMMENT '0未启动 1运行 2 停止 3 异常',
        `create_time` datetime DEFAULT NULL COMMENT '添加时间'
    */

    /**
     * 爬虫名称
     */
   private String crawler;
    /**
     * cookie
     */
   private String code;

   /**
     * cookie
     */
   private String cookie;

    /**
     * 网站类型
     */
   private Integer type;

   /**
     * 账号类型
     */
   private Integer  accountType;

    /**
     * 账号类型名称
     */
   private String accountTypeName;

    /**
     * 信息获取数量
     */
   private Long count;
    /**
     * 网站地址
     */
   private String url;
    /**
     * 爬虫运行状态
     */
   private Integer status;

    public Crawler() {
        this.status = 0;
    }

    /**
     * 备注
     */
    private String remarks;

    public String getCrawler() {
        return crawler;
    }

    public void setCrawler(String crawler) {
        this.crawler = crawler;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
