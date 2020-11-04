package com.trx.springboot.rocketmq.springbootrocketmqdemo.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MessageSender {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void syncSend() {

        SendResult result = rocketMQTemplate.syncSend("springboot-topic:tag", "这是一条同步消息", 10000);

        System.out.println(result);
    }


    public void asyncSend() throws Exception {

        rocketMQTemplate.asyncSend("springboot-topic:tag1", "这是一条异步消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

                System.out.println("回调SendResult：" + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {

                System.out.println(throwable.getMessage());

            }
        });
        TimeUnit.SECONDS.sleep(100000);
    }


    public void sendOneWay() {

        rocketMQTemplate.sendOneWay("springboot-topic:tag1", "这是一条单向消息");
    }

    public void sendoneWayOrderly() {

        for (int i = 0; i < 10; i++) {

            rocketMQTemplate.sendOneWayOrderly("springboot-topic:tag1", "这是一条顺序消息" + i, "2673");
            rocketMQTemplate.sendOneWayOrderly("springboot-topic:tag1", "这是一条顺序消息" + i, "2673");
        }
    }

}
