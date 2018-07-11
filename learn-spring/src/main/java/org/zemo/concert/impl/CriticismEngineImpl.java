package org.zemo.concert.impl;

import org.zemo.concert.CriticismEngine;

/**
 * @ClassName: CriticismEngineImpl
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 01/10/2016 17:52
 * @Description ${TODO}
 */
public class CriticismEngineImpl implements CriticismEngine {
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool){
        this.criticismPool = criticismPool;
    }

    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }
}
