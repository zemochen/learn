package org.zemo.concert.impl;

import org.zemo.concert.Performance;

/**
 * @ClassName: PerformanceImpl
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 01/10/2016 17:48
 * @Description ${TODO}
 */
public class PerformanceImpl implements Performance {
    public boolean perform() {

        System.out.println("This is the Show");
        return true;
    }
}
