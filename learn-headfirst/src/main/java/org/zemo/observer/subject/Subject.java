package org.zemo.observer.subject;

import org.zemo.observer.observer.Observer;

/**
 * @ClassName: Subject
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/17/16 17:26
 * @Description ${TODO}
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
