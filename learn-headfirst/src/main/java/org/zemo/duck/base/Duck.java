package org.zemo.duck.base;

/**
 * @ClassName: Duck
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/12/16 18:05
 * @Description ${TODO}
 */
public abstract class Duck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
    }

    public void display() {
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
