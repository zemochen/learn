package org.zemo.proxy;

/**
 * @ClassName: HelloImpl
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/26/16 10:25
 * @Description ${TODO}
 */
public class HelloImpl implements Hello {
    private volatile String infos1;

    private volatile String infos2;

    public String getInfos1() {
        return infos1;
    }

    public String getInfos2() {
        return infos2;
    }

    public void setInfo(String infos1, String infos2) {
        this.infos1 = infos1;
        this.infos2 = infos2;
    }

    public void display() {
        System.out.println("\t\t" + infos1 + "\t" + infos2);
    }
}
