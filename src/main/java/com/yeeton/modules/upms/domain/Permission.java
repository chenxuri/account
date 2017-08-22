package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseTreeEntity;

import java.util.Date;

/**
 * Created by user on 2017/7/2.
 */
public class Permission extends BaseTreeEntity<Long> {

    /**
     * 所属系统
     */
    private Long platformId;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型(1:目录,2:菜单,3:按钮)
     */
    private Integer type;
    /**
     * 权限值
     */
    private String permissionValue;
    /**
     *路径
     */
    private String uri;
    /**
     *图标
     */
    private String icon;
    /**
     *状态(-1:禁止,1:正常)
     */
    private Integer status;
    /**
     *排序
     */
    private Integer sequence;


    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
