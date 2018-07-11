package org.zemo.cocurrent.thread;

/**
 * @ClassName: PendingInterrupt
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 05/06/2017 11:36
 * @Description 待决中断，中断则不会sleep，否则sleep
 */
public class PendingInterrupt {
    //是否中断线程
    public void isInterrupt(boolean isInterrupt){
        if (isInterrupt) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        PendingInterrupt pendingInterrupt = new PendingInterrupt();
        pendingInterrupt.isInterrupt(true);

        //获取当前时间
        long startTime = System.currentTimeMillis();
        try{
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        }catch(InterruptedException x){
            System.out.println("was interrupted");
        }
        //计算中间代码执行的时间
        System.out.println("elapsedTime=" + ( System.currentTimeMillis() - startTime));
    }

}
