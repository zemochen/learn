package org.zemo.duck.duck;

import org.zemo.duck.base.Duck;
import org.zemo.duck.fly.FlyWithWings;
import org.zemo.duck.quack.Quack;

/**
 * @ClassName: MallardDuck
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 15:54
 * @Description ${TODO}
 */
public class MallardDuck extends Duck {

    public  MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("I'm a real Mallard duck");
    }
}
