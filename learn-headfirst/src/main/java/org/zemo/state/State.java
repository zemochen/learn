package org.zemo.state;

/**
 * @ClassName: State
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016/10/1 22:04
 * @Description 状态机
 */
public interface State {
    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 退币
     */
    void ejectQuarter();

    /**
     * 搬遥感
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();
}
