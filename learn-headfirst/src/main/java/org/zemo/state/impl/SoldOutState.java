package org.zemo.state.impl;

import org.zemo.state.GumballMachine;
import org.zemo.state.State;

/**
 * @ClassName: SoldOutState
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:11
 * @Description 售罄状态
 */
public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("SOLD_OUT-INSERT:You've insert a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
        gumballMachine.ejectQuarter();
        System.out.println("SOLD_OUT-INSERT:Sold out!");
        gumballMachine.setState(gumballMachine.getSoldOutState());
    }

    public void ejectQuarter() {
        System.out.println("SOLD_OUT-EJECT:You can't eject/insert quarter,it's sold out");
    }

    public void turnCrank() {
        System.out.println("SOLD_OUT-TURN:Turned...");
    }

    public void dispense() {
        System.out.println("SOLD_OUT-DISPENSE:No gumball dispensed... Sold out");
    }
}
