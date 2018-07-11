package org.zemo.cocurrent.producer;

/**
 * @ClassName: Producer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 22/08/2017 10:59
 * @Description 生产者消费者模式--生产者
 */
public class Producer implements Runnable {

    private Resource resource;

    public Producer(Resource resource) {

        this.resource = resource;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.create();
        }
    }
}
