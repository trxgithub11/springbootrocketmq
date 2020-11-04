package com.trx.springboot.rocketmq.springbootrocketmqdemo.consumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic="springboot-topic",consumerGroup="qs-consumer-group",messageModel = MessageModel.CLUSTERING,consumeMode = ConsumeMode.CONCURRENTLY)
public class MessageConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {

        System.out.println("----接收到rocketmq消息-----"+s);
    }
}
