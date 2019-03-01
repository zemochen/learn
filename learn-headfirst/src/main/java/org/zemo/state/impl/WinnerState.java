package org.zemo.state.impl;

import org.zemo.state.GumballMachine;
import org.zemo.state.State;

/**
 * @ClassName: WinnerState
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:14
 * @Description 10%的用户可以获得买一赠一
 */
public class WinnerState implements State {
    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {

    }

    public void ejectQuarter() {

    }

    public void turnCrank() {

    }

    public void dispense() {

    }
}
