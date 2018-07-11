package org.zemo.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zemo.kafka.spring.consumer.KafkaConsumer;
import org.zemo.kafka.spring.producer.KafkaProducer;

/**
 * @ClassName: KafkaClientTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 06/04/2017 23:55
 * @Description ${TODO}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class KafkaClientTest {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Test
    public void test() throws Exception {
        kafkaProducer.send("hotel_sync_fullinfo_from_fisv2", "hello kafka");
    }

    /*@Test
    public void recevie(){
        kafkaConsumer.onMessage();
    }*/

    @Test
    public void testSend(){
        String topic = "hotel_sync_fullinfo_from_fisv2";
        String value = "hello kafka test";
        String ifPartition = "0";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        kafkaProducer.sndMesForTemplate
                (topic, value, ifPartition, partitionNum, role);
    }
}
