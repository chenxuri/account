package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

/**
 * Created by user on 2017/7/2.
 */
public class Role extends BaseEntity<Long> {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色标题
     */
    private String title;
    /**
     * 角色描述
     */
    private String remarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
