package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

/**
 * Created by user on 2017/8/11.
 */
public class Org  extends BaseEntity<Integer> {


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


  private String name;
  private Integer induId;
  private String industry;
  private Integer provinceId;
  private String ip;
  private String alias;
  private Double longitude;
  private Double latitude;
  private String orglocation;
  private String locationFid;
  private String orglocationall;
  private String indu;
  private Integer customer;
  private Integer level;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInduId() {
        return induId;
    }

    public void setInduId(Integer induId) {
        this.induId = induId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getOrglocation() {
        return orglocation;
    }

    public void setOrglocation(String orglocation) {
        this.orglocation = orglocation;
    }

    public String getLocationFid() {
        return locationFid;
    }

    public void setLocationFid(String locationFid) {
        this.locationFid = locationFid;
    }

    public String getOrglocationall() {
        return orglocationall;
    }

    public void setOrglocationall(String orglocationall) {
        this.orglocationall = orglocationall;
    }

    public String getIndu() {
        return indu;
    }

    public void setIndu(String indu) {
        this.indu = indu;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
