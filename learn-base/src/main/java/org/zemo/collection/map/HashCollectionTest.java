package org.zemo.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: HashCollectionTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/6/16 11:36
 * @Description ${TODO}
 */
public class HashCollectionTest {
    private HashMap<String, Object> hashMap;
    private Hashtable<String, Object> hashtable;
    private ConcurrentHashMap<String, Object> concurrentHashMap;


    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
//        Collections.synchronizedMap(map);
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        public void run() {
                            //去掉同步锁，会造成死锁
//                            synchronized (map){

                                map.put(UUID.randomUUID().toString(), "");
//                            }
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
