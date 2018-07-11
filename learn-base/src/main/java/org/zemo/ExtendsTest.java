package org.zemo;

/**
 * @ClassName: ExtendsTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/29/16 11:03
 * @Description ${TODO}
 */
public class ExtendsTest extends HelloA {
    public ExtendsTest(){
        System.out.println("ExtendsTest");
    }
    {
        System.out.println("I'm class B");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        System.out.println("--------start-----------");
        new ExtendsTest();
        new ExtendsTest();
        System.out.println("--------end-----------");
    }
}
class HelloA{
    public HelloA() {
        System.out.println("HelloA");
    }
    {
        System.out.println("I'm class A");
    }

    static {
        System.out.println("static A");
    }
}
