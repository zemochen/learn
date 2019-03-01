package org.zemo;

/**
 * @ClassName: IntegerTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2019/3/1 22:25
 * @Description
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a1 = 127;
        Integer a2 = 127;
        System.out.println(a1 == a2);
        Integer b1 = 128;
        Integer b2 = 128;
        System.out.println(b1 == b2);
        //Integer 中有IntegerCache 缓存-128~127的数字，在这区间内，使用缓存中比较，区间外比较内存地址
        a1--;
        System.out.println(a1);
        a2 -= 1;
        System.out.println(a2);
    }
}
