package com.iot.config.rabbitmq;

import com.iot.vo.LogInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author weiyunyun
 * @date 2020/2/13 13:08
 */
@Configuration
@Slf4j
public class ApiCoreSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendStrMsg(String message){
        log.info("api.core.user send message :{} ",message);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", message);
    }

}
