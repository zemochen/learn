package org.zemo.state;

import org.zemo.state.impl.HasQuarterState;
import org.zemo.state.impl.NoQuarterState;
import org.zemo.state.impl.SoldOutState;
import org.zemo.state.impl.SoldState;

/**
 * @ClassName: GumballMachine
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:08
 * @Description 糖果机，投币后，搬动摇杆，出糖果
 */
public class GumballMachine {
    //售罄状态
    private State soldOutState;
    //没有投币状态
    private State noQuarterState;
    //已投币状态
    private State hasQuarterState;
    //出售状态
    private State soldState;


    private State state = this.soldOutState;
    //糖果机糖量
    private int count = 0;

    public GumballMachine(int numberGumballs) {
        this.noQuarterState = new NoQuarterState(this);
        this.soldOutState = new SoldOutState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.count = numberGumballs;
        if (this.count > 0) {
            state = noQuarterState;
        }
    }

    /*******************行为**********************/
    /**
     * 投入硬币
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * 弹出硬币
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 搬摇杆
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void releaseBall() {
        if (count != 0) {
            System.out.println("A gumball comes rolling out the slot...");
            count--;
        }
    }

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(2);
        System.out.println("================= 1 ======================");
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine.getCount());
        System.out.println("================= 2 ======================");
        gumballMachine.ejectQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine.getState());
        System.out.println("================= 3 ======================");
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
    }

}
