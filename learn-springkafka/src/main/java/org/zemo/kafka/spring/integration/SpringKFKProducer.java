package org.zemo.kafka.spring.integration;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.Random;

/**
 * @ClassName: SpringKFKProducer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 06/04/2017 21:02
 * @Description ${TODO}
 */
public class SpringKFKProducer {

    private static final String CONFIG = "/integration/spring-kafka-producer.xml";
    private static Random rand = new Random();

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIG, SpringKFKProducer.class);
        ctx.start();
        final MessageChannel channel = ctx.getBean("inputToKafka", MessageChannel.class);
        for (int i = 0; i < 100; i++) {
            channel.send(MessageBuilder.withPayload("Message-" + rand.nextInt()).setHeader("messageKey", String.valueOf(i)).setHeader("topic", "hotel_sync_fullinfo_from_fisv2").build());
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ctx.close();
    }
}
