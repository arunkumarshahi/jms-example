package com.example.demo.listener;

import com.example.demo.config.JmsConfig;
import com.example.demo.model.HelloWorldMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class MessageListener {
    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloMessage, @Headers MessageHeaders messageHeaders, Message message) {
        log.info("i recieved a message");
        log.info(helloMessage.toString());
    }
}
