package org.zemo.kafka.spring.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;

/**
 * @ClassName: KafkaConsumer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 06/04/2017 23:53
 * @Description 消息消费者
 */

public class KafkaConsumer implements MessageListener<Integer, String> {


    @KafkaListener(id="0",topics = {"hotel_sync_fullinfo_from_fisv2"})
    public void onMessage(ConsumerRecord<Integer, String> record) {
        System.out.println("receive:" + record);
    }

    @KafkaListener(id = "fis", topics = "hotel_sync_fullinfo_from_fisv2")
    public void listenFis() {

    }
}