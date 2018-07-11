package org.zemo.kafka.ntv;


import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;
import java.util.Random;

/**
 * @ClassName: NativeProducer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 05/04/2017 14:58
 * @Description ${TODO}
 */
public class NativeProducer {

    public static void main(String[] args) {
        String topic= "test";
        long events = 100;
        Random rand = new Random();

        Properties props = new Properties();
        props.put("metadata.broker.list", "192.168.10.103:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);

        for (long nEvents = 0; nEvents < events; nEvents++) {
            String msg = "NativeMessage-2-" + rand.nextInt() ;
            KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, nEvents + "", msg);
            producer.send(data);
        }
        producer.close();
    }
}
