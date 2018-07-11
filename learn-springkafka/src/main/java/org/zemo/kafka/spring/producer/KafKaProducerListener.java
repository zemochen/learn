package org.zemo.kafka.spring.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

/**
 * @ClassName: KafKaProducerListener
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 10/04/2017 14:14
 * @Description ${TODO}
 */
public class KafKaProducerListener implements ProducerListener {
    protected final Logger logger = LoggerFactory.getLogger(KafKaProducerListener.class);

    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {

    }

    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        logger.info("send error,topic:" + topic);
        logger.info("send error,partition:" + partition);
        logger.info("send error,key:" + key);
        logger.info("send error,value:" + value);
        logger.info("send error,exception:" + exception);
        exception.printStackTrace();
    }

    /**
     * 是否启动监听器
     * @return
     */
    public boolean isInterestedInSuccess() {
        return true;
    }
}
