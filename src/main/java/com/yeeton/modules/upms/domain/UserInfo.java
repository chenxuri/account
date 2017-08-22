package com.yeeton.modules.upms.domain;

import com.yeeton.common.base.BaseEntity;

import java.util.Date;

/**
 * 用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class UserInfo extends BaseEntity<String> {

    /*CREATE TABLE `sys_user` (
            `id` varchar(64) NOT NULL COMMENT '编号',
            `company_id` varchar(64) DEFAULT NULL COMMENT '归属公司',
            `office_id` varchar(64) DEFAULT NULL COMMENT '归属部门',
            `login_name` varchar(100) DEFAULT NULL COMMENT '登录名',
            `password` varchar(100) DEFAULT NULL COMMENT '密码',
            `no` varchar(100) DEFAULT NULL COMMENT '工号',
            `name` varchar(100) DEFAULT NULL COMMENT '姓名',
            `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
            `phone` varchar(200) DEFAULT NULL COMMENT '电话',
            `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
            `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
            `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
            `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
            `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
            `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
            `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
            `create_date` datetime DEFAULT NULL COMMENT '创建时间',
            `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
            `update_date` datetime DEFAULT NULL COMMENT '更新时间',
            `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
            `del_flag` char(1) DEFAULT '0' COMMENT '删除标记',
            `qrcode` varchar(1000) DEFAULT NULL COMMENT '二维码',*/
    private String  username;
    private String  password;
    private String  no;
    private String  name;
    private String  phone;
    private String  photo;
    private String  email;
    private String  loginIp;
    private String  loginDate;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }
}
