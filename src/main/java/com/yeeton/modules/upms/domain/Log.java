package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

/**
 * Created by user on 2017/7/2.
 */
public class Log extends BaseEntity<Long> {
    /**
     * 操作用户
     */
    private String username;
    /**
     * 操作时间
     */
    private String startTime;
    /**
     * 消耗时间
     */
    private String spendTime;
    /**
     * 根路径
     */
    private String basePath;
    /**
     * URI
     */
    private String uri;
    /**
     * URL
     */
    private String url;
    /**
     * 请求类型
     */
    private String method;
    /**
     * 请求参数
     */
    private String parameter;
    /**
     * 用户标识
     */
    private String userAgent;
    /**
     * 请求IP地址
     */
    private String ip;
    /**
     * 结果
     */
    private String result;
    /**
     * 权限
     */
    private String permissions;
    /**
     * 描述
     */
    private String description;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
