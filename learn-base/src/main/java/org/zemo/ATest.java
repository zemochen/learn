package org.zemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: ATest
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2022/10/27
 * @Description
 */
public class ATest {


    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("ss");
        for (String s : set) {

            System.out.println(s);
        }

        Map<String, String> map = new HashMap();
        map.put("", "");
        for (String s : map.keySet()) {

            System.out.println(14>>>2);
        }

        A a = new A(1);
        A b = new A(2);

        System.out.println("a=" + a + ",b=" + b);
        System.out.println("a.a=" + a.a + ",b.a=" + b.a);
        swap(a, b);
        System.out.println("a=" + a + ",b=" + b);
        System.out.println("a.a=" + a.a + ",b.a=" + b.a);


    }

    static void swap(A a, A b) {
        A tmp = a;
        a = b;
        b = tmp;

        a.a = 5;
        b.a = 6;
        System.out.println("a=" + a + ",b=" + b);
    }
    static class A{

        public A(Integer a) {
            this.a = a;
        }

        Integer a = new Integer(0);



    }

}
