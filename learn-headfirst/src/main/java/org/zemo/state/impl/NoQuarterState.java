package org.zemo.state.impl;

import org.zemo.state.GumballMachine;
import org.zemo.state.State;

/**
 * @ClassName: NoQuarterState
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:12
 * @Description 未投币状态
 */
public class NoQuarterState implements State {
    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("NO_QUARTER-INSERT:You've inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("NO_QUARTER-EJECT:You haven't inserted a quarter");
    }

    public void turnCrank() {
        System.out.println("NO_QUARTER-TURN:Turned, but there's no quarter");
    }

    public void dispense() {
        System.out.println("NO_QUARTER-DISPENSE:You need to pay first");
    }
}
