package org.zemo.observer.observer;

/**
 * @ClassName: Observer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/17/16 17:26
 * @Description ${TODO}
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
