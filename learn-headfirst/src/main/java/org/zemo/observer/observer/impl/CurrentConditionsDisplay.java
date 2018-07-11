package org.zemo.observer.observer.impl;

import org.zemo.observer.DisplayElement;
import org.zemo.observer.observer.Observer;
import org.zemo.observer.subject.Subject;

/**
 * @ClassName: CurrentConditionsDisplay
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 06/06/2017 10:08
 * @Description ${TODO}
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and "
                + humidity + "% humidity");
    }

    public void unSubject(){
        weatherData.removeObserver(this);
    }
}
