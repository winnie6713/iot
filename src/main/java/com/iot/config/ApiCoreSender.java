package com.iot.config;

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

    public void sendStrMsg(LogInfoVo logInfoVo){
        log.info("api.core.user send message :{} ",logInfoVo);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", logInfoVo);
    }

    public void sendByteMsg(byte[] msg){
        log.info("api.core.user send message :{} ",msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

}
