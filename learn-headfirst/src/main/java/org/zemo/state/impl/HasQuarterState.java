package org.zemo.state.impl;

import org.zemo.state.GumballMachine;
import org.zemo.state.State;

/**
 * @ClassName: HasQuarterState
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:13
 * @Description 已投币状态
 */
public class HasQuarterState implements State {

    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("HAS_QUARTER-INSERT:Quarter had inserted.You can't insert another quarter");
    }

    public void ejectQuarter() {
        System.out.println("HAS_QUARTER-EJECT:Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("HAS_QUARTER-TURN:You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("HAS_QUARTER-DISPENSE:No gumball dispensed");
    }

}
