package org.zemo.cocurrent.producer;

/**
 * @ClassName: Consumer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 22/08/2017 11:01
 * @Description 生产者消费者模式--消费者
 */
public class Consumer implements Runnable {

    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.destroy();
        }
    }
}
