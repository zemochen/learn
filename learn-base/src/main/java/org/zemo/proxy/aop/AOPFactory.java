package org.zemo.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: AOPFactory
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/26/16 10:28
 * @Description AOP的agent
 */
public class AOPFactory implements InvocationHandler {

    private Object proxyed;

    public AOPFactory(Object proxyed) {
        this.proxyed = proxyed;
    }

    public void printInfo(String info, Object... args) {
        System.out.println(info);
        if (args == null) {
            System.out.println("\t空值。");
        }else {
            for(Object obj : args) {
                System.out.println(obj);
            }
        }
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("\n\n====>调用方法名：" + method.getName());
        Class<?>[] variables = method.getParameterTypes();
        for(Class<?>typevariables: variables) {
            System.out.println("=============>" + typevariables.getName());
        }
        printInfo("传入的参数为：", args);
        Object result = method.invoke(this.proxyed, args);
        printInfo("返回的参数为：", result);
        printInfo("返回值类型为：", method.getReturnType());
        return result;
    }
}
