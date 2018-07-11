package org.zemo.cocurrent.producer;

/**
 * @ClassName: Resource
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 22/08/2017 10:54
 * @Description 生产者消费者模式--资源
 */
public class Resource {

    //资源序号
    private int number = 0;

    //资源标记
    private boolean flag = false;

    public synchronized void create(){
        //如果已经生产了，等待消费
        while (flag) {  //这里如果用if只判断一次， 高并发时可能会遇到多次消费或多次生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number++;
        System.out.println(Thread.currentThread().getName() + "生产者：" + number);
        flag = true;    //标记为已生产
        notifyAll();       //唤醒等待的线程
    }

    /**
     * 消费资源
     */
    public synchronized void destroy(){
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "消费者:" + number);

        flag = false;
        notifyAll();

    }
}
