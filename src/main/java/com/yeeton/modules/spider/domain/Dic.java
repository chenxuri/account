package com.yeeton.modules.spider.domain;

import com.yeeton.common.base.BaseTreeEntity;

/**
 * Created by user on 2017/8/17.
 */
public class Dic extends BaseTreeEntity<Long> {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
