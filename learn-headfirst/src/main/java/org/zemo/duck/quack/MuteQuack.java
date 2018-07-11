package org.zemo.duck.quack;

import org.zemo.duck.base.QuackBehavior;

/**
 * @ClassName: MuteQuack
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 17:43
 * @Description ${TODO}
 */
public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack:...");
    }
}
