package org.zemo.state.impl;

import org.zemo.state.GumballMachine;
import org.zemo.state.State;

/**
 * @ClassName: SoldState
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:13
 * @Description 出售
 */
public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("SOLD-INSERT:Please wait,we're alread giving you a gumball");
    }

    public void ejectQuarter() {
        System.out.println("SOLD-EJECT:Sorry,you've already turned the crank");
    }

    public void turnCrank() {
        System.out.println("SOLD-TURN-Turning twice doesn't get you another gumball!");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("SOLD-DISPENSE:Oops,out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
