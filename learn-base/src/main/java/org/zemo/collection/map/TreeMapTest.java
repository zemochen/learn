package org.zemo.collection.map;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName: TreeMapTest
 * @author: superzemo
 * @email: zemochen@gmail.com
 * @Date 2018/7/28 11:07 AM
 * @Description
 */
public class TreeMapTest {

    public static HashMap<String, String> treemap = new HashMap<String, String>();


    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            new Thread(() -> {
                while (true) {
                    treemap.get(random.nextInt(50)+"");
                }
            }).start();
        }

        while (true) {
            Random random = new Random();
            treemap.put(random.nextInt(50)+"", UUID.randomUUID().toString());
        }
    }
}
