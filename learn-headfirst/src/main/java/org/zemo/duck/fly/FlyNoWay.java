package org.zemo.duck.fly;

import org.zemo.duck.base.FlyBehavior;

/**
 * @ClassName: FlyNoWay
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 17:42
 * @Description ${TODO}
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly...");
    }
}
