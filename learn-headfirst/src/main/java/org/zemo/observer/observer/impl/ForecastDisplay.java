package org.zemo.observer.observer.impl;

import org.zemo.observer.DisplayElement;
import org.zemo.observer.observable.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: ForecastDisplay
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 07/06/2017 10:39
 * @Description ${TODO}
 */
public class ForecastDisplay implements Observer,DisplayElement{
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);

    }

    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    public void display() {

    }
}
