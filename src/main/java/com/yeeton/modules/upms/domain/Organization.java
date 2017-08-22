package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

/**
 * Created by user on 2017/7/2.
 */
public class Organization extends BaseEntity<Integer> {

  /*   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `szname` varchar(64) CHARACTER SET gb2312 NOT NULL,
  `ninduid` int(10) unsigned DEFAULT NULL,
  `nprovinceid` int(10) unsigned DEFAULT NULL,
  `szip` varchar(30) CHARACTER SET gb2312 DEFAULT NULL,
  `szalias` varchar(256) CHARACTER SET gb2312 DEFAULT NULL COMMENT '别名',
            `szReserved` varchar(256) CHARACTER SET gb2312 DEFAULT NULL,
  `longitude` double(12,7) DEFAULT NULL,
  `latitude` double(12,7) DEFAULT NULL,
  `orglocation` varchar(100) DEFAULT NULL,
  `location_fid` varchar(32) DEFAULT NULL,
  `orglocationall` varchar(255) DEFAULT NULL,
  `subindu` int(10) DEFAULT '0',
            `customer` int(2) DEFAULT '0',
            `level` int(10) DEFAULT '0',*/

    /**
     *组织名称
     */
    private String name;
    /**
     *组织英文名称
     */
    private String enName;

    /**
     * 机构别名
     */
    private String alias;

    /**
     *组织编号
     */
    private String code;
    /**
     *地址编号
     */
    private String areaCode;
     /**
     *地址
     */
    private String address;

    /**
     *负责人
     */
    private User master;

    /**
     *所属行业
     */
    private Industry industry;

    /**
     *官方网站
     */
    private String website;
    /**
     *官方电话
     */
    private String phone;
    /**
     *官方邮箱
     */
    private String email;
    /**
     *组织描述
     */
    private String remarks;

    /**
     *修改时间
     */
    private String modifyTime;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
