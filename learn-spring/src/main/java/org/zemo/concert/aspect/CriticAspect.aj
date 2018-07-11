package org.zemo.concert.aspect;

import org.zemo.concert.impl.CriticismEngineImpl;

/**
 * @ClassName: CriticAspect
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 01/10/2016 17:49
 * @Description ${TODO}
 */
public aspect CriticAspect {
    public CriticAspect() {
    }
    pointcut performance() : execution(* org.zemo.concert.Performance.perform(..));

    /*afterReturning() : performance() {
        System.out.println(criticismEngine.getCriticism());
    }*/

    private CriticismEngineImpl criticismEngine;

    public void setCriticismEngine(CriticismEngineImpl criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

}
