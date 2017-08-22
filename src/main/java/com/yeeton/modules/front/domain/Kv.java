package com.yeeton.modules.front.domain;

import java.io.Serializable;

/**
 * Created by user on 2017/7/7.
 */
public class Kv implements Serializable{
    private String n;
    private Integer v;

    public Kv() {
    }

    public Kv(String n, Integer v) {
        this.n = n;
        this.v = v;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
