package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

import java.util.Date;

/**
 * Created by user on 2017/7/2.
 */
public class Logon extends BaseEntity<Long> {

    /**
     * 访问对象Id(用户或者机构)
     */
    private Long access;
    /**
     * 访问对象登录名
     */
    private String username;
    /**
     * 访问对象登录密码
     */
    private String password;
    /**
     * 1:用户；2：机构
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getAccess() {
        return access;
    }

    public void setAccess(Long access) {
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
