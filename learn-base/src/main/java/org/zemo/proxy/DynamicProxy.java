package org.zemo.proxy;

import org.zemo.proxy.aop.AOPFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName: DynamicProxy
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/26/16 10:30
 * @Description 测试调用类入口
 */
public class DynamicProxy {
    public static Object getBean(String className) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        Object obj = Class.forName(className).newInstance();
        InvocationHandler handler = new AOPFactory(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
                .getClass().getInterfaces(), handler);
    }
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) getBean("org.zemo.proxy.HelloImpl");
            hello.setInfo("zemo1", "zemo2");
            hello.getInfos1();
            hello.getInfos2();
            hello.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
