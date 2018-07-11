package org.zemo.cocurrent.producer;

/**
 * @ClassName: ProducerConsumerTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 22/08/2017 11:04
 * @Description ${TODO}
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Producer(resource)).start();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
        new Thread(new Consumer(resource)).start();

    }
}
