package com.learn.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-23 22:37
 **/
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 收到的消息
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者1号----->收到消息: "+message.getPayload()+"\t port: "+serverPort);
    }
}
