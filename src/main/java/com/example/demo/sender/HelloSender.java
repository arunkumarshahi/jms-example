package com.example.demo.sender;

import com.example.demo.config.JmsConfig;
import com.example.demo.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
@Accessors(chain = true)
public class HelloSender {
    private  final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){

        System.out.println("I'm Sending a message");

        HelloWorldMessage message = new HelloWorldMessage();

        message.setId(UUID.randomUUID());
                message.setMessage("Hello World!");


        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message Sent!");

    }
}
