package org.zemo.duck.duck;

import org.zemo.duck.base.Duck;
import org.zemo.duck.fly.FlyNoWay;
import org.zemo.duck.quack.Quack;

/**
 * @ClassName: ModeDuck
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 17:57
 * @Description ${TODO}
 */
public class ModeDuck extends Duck {
    public ModeDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I'm a mode duck.");
    }
}
