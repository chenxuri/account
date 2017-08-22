package com.yeeton.modules.upms.domain;


import com.yeeton.common.base.BaseTreeEntity;

/**
 * Created by user on 2017/7/6.
 */
public class Industry extends BaseTreeEntity<Long> {
    /**
     * 行业名称
     */
    private String name;

    /**
     * 行业编码
     */
    private String code;

    /**
     * 行业描述
     */
    private String remarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
