import java.util.Scanner;

/**
 * @ClassName: StringTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 18/10/2016 10:06
 * @Description ${TODO}
 */
public class StringTest {
    public static void main(String[] args) {
        String foo = "blue";
        String bar = foo;
        String ze = new String("test");
        ze = foo;
        foo = "green";
        System.out.println(ze);
        System.out.println(bar);

        System.out.println(101%50);
    }
}
