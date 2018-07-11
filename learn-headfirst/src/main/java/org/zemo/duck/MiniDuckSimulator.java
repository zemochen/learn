package org.zemo.duck;

import org.zemo.duck.base.Duck;
import org.zemo.duck.duck.MallardDuck;
import org.zemo.duck.duck.ModeDuck;
import org.zemo.duck.fly.FlyRocketPowered;

/**
 * @ClassName: MiniDuckSimulator
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/15/16 17:45
 * @Description ${TODO}
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        //mode duck simulator
        System.out.println("-----------mode duck--------");
        Duck mode = new ModeDuck();
        mode.performFly();
        mode.setFlyBehavior(new FlyRocketPowered());
        mode.performFly();
    }
}
