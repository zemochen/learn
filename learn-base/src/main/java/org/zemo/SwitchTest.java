package org.zemo;

/**
 * @ClassName: SwitchTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/29/16 10:22
 * @Description ${TODO}
 */
public class SwitchTest {

    private static void ten(int i) {
        int result = 0;
        switch(i){
            case  1:
                result = result + i;
            case  2:
                result = result + i * 2;
            case  3:
                result = result + i * 3;
            case 5:
                result = result + i * 5;
        }
        System.out.println("result="+result);
        System.out.println("10. 10");
    }

    public static void main(String[] args) {
        ten(2);
    }
}
