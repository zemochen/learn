package org.zemo;

/**
 * @ClassName: NULL
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/29/16 10:25
 * @Description ${TODO}
 */
public class NULL {

    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};
    public static void hello(){
        System.out.println("hello");
    }

    public static void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {

        ((NULL) null).hello();
        String str = new String("ok");
        NULL ex = new NULL();
        ex.change(str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}
