package com.yeeton.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by user on 2017/6/27.
 */
public abstract class BaseTreeEntity<T> {
    private T id;
    private T pid;
    private String pidPath;

    /**
     *创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Transient
    private Date startCreated;

    @Transient
    private Date endCreated;

    public BaseTreeEntity() {
        this.setCreateTime(new Date());
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getPid() {
        return pid;
    }

    public void setPid(T pid) {
        this.pid = pid;
    }

    public String getPidPath() {
        return pidPath;
    }

    public void setPidPath(String pidPath) {
        this.pidPath = pidPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartCreated() {
        return startCreated;
    }

    public void setStartCreated(Date startCreated) {
        this.startCreated = startCreated;
    }

    public Date getEndCreated() {
        return endCreated;
    }

    public void setEndCreated(Date endCreated) {
        this.endCreated = endCreated;
    }
}
