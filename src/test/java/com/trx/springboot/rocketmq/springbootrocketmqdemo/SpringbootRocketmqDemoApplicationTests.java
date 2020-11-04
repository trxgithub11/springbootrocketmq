package com.trx.springboot.rocketmq.springbootrocketmqdemo;

import com.trx.springboot.rocketmq.springbootrocketmqdemo.producer.MessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRocketmqDemoApplicationTests {


    @Autowired
    private MessageSender messageSender;
    @Test
    void contextLoads() {
    }

    @Test
    public void test(){

        messageSender.syncSend();
    }

}
