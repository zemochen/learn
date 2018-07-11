package org.zemo;

/**
 * @ClassName: ForTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/29/16 10:48
 * @Description ${TODO}
 */
public class ForTest {
    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A');foo('B')&&(i<2);foo('C')) {
            i++;
            foo('D');
        }
    }
}
