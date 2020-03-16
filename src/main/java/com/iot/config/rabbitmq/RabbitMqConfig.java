package com.iot.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author weiyunyun
 * @date 2020/2/12 18:04
 */
@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;
    /**
     * 声明一个为string的队列
     */
    @Bean
    public Queue coreQueue(){
        return new Queue("api.core") ;
    }

    @Bean
    public Queue paymentQueue(){
        return new Queue("api.payment");
    }

    @Bean
    public TopicExchange coreExchange(){
        return new TopicExchange("coreExchange");
    }

    @Bean
    public TopicExchange paymentExchange(){
        return new TopicExchange("paymentExchange");
    }

    @Bean
    public Binding bindingCoreExchange(){
        return BindingBuilder.bind(coreQueue()).to(coreExchange()).with("api.core.*");
    }

    @Bean
    public Binding bindingPaymentExchange(){
        return BindingBuilder.bind(paymentQueue()).to(paymentExchange()).with("api.payment.#");
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        //rabbitmq IP 端口号
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, Integer.valueOf(port));
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

}
