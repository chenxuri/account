package com.yeeton;

import com.yeeton.common.config.amqp.AmqpConstant;
import com.yeeton.common.config.amqp.CrawlerMessage;
import com.yeeton.common.config.amqp.KeywordMessage;
import com.yeeton.modules.spider.dao.CrawlerDao;
import com.yeeton.modules.spider.domain.Crawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by user on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    CrawlerDao crawlerDao;
/*
    @Test
    public void contextLoads() {
        KeywordMessage keywordMessage = new KeywordMessage();
        keywordMessage.setKeywords("aa");
        keywordMessage.setOrgId(1l);
        keywordMessage.setOrgName("org");
        this.rabbitTemplate.convertSendAndReceive("keywordFanoutExchange","",keywordMessage);
    }*/

    @Test
    public void topic(){
        CrawlerMessage crawlerMessage = new CrawlerMessage();
        crawlerMessage.setCode("start");
        crawlerMessage.setCrawlerId(5l);
        Crawler crawler = crawlerDao.selectByPrimaryKey(5l);
       // for (Crawler crawler : crawlerDao.selectAll()) {
            this.rabbitTemplate.convertAndSend(AmqpConstant.exchange,"message."+crawler.getCode(), crawlerMessage);
       // }
      //  this.rabbitTemplate.convertAndSend(AmqpConstant.exchange,AmqpConstant.message_webchat, "ddsaddsdsa");
    }
}
