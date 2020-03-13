package com.iot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

/**
 * @author weiyunyun
 * @date 2020/2/13 13:07
 */
@Configuration
@Slf4j
public class ApiPaymentReceive {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitHandler
    @RabbitListener(queues = "api.payment")
    public void order(String msg) {
        log.info("api.payment.order receive message: "+msg);
    }
}
