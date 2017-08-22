package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

import java.util.Date;

/**
 * Created by user on 2017/7/2.
 */
public class Platform extends BaseEntity<Long> {

    /**
     * 图标
     */
    private String icon;
    /**
     * 背景
     */
    private String banner;
    /**
     * 主题
     */
    private String theme;
    /**
     * 根目录
     */
    private String basepath;
    /**
     * 状态(-1:黑名单,1:正常)
     */
    private String status;
    /**
     * 系统名称
     */
    private String name;
    /**
     * 系统标题
     */
    private String title;
    /**
     * 排序
     */
    private String sequence;
    /**
     * 系统描述
     */
    private String remarks;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
