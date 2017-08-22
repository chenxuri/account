package com.yeeton.common.config.amqp;

import java.io.Serializable;

/**
 * Created by user on 2017/8/3.
 */
public class CrawlerMessage implements Serializable {

    private String code;
    private Long crawlerId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCrawlerId() {
        return crawlerId;
    }

    public void setCrawlerId(Long crawlerId) {
        this.crawlerId = crawlerId;
    }

    @Override
    public String toString() {
        return "CrawlerMessage{" +
                "code='" + code + '\'' +
                ", crawlerId=" + crawlerId +
                '}';
    }
}
