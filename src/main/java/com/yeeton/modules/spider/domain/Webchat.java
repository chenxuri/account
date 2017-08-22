package com.yeeton.modules.spider.domain;

import com.yeeton.common.base.BaseEntity;
import com.yeeton.modules.upms.domain.Organization;

import java.util.Date;

/**
 * Created by user on 2017/6/22.
 */
public class Webchat extends BaseEntity<Long> {


    private String searchkey ;       // 搜索关键词
    private String name ;       // 公众号名称
    private String wechatid;    //公众号ID
    private String jieshao;     //介绍
    private String renzhen;     //认证信息，为空表示未认证
    private String qrcode;      //二维码图片地址
    private String img;         //头像地址
    private String url;         //微信URL
    private Integer status;         //状态：0未处置 1风险 2 官方 3 诈骗
    private Organization organization;

    public Webchat() {
        this.setCreateTime(new Date());
    }

    public String getSearchkey() {
        return searchkey;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechatid() {
        return wechatid;
    }

    public void setWechatid(String wechatid) {
        this.wechatid = wechatid;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public String getRenzhen() {
        return renzhen;
    }

    public void setRenzhen(String renzhen) {
        this.renzhen = renzhen;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
