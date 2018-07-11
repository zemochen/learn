package org.zemo.observer.observer.impl;

import org.zemo.observer.DisplayElement;
import org.zemo.observer.observer.Observer;
import org.zemo.observer.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CurrentConditionsDisplay
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 06/06/2017 10:08
 * @Description ${TODO}
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private List<Float> temperatures;
    private float maxT;
    private float minT;
    private float avgT;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        temperatures = new ArrayList();
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        if (temperatures == null || temperatures.size() == 0) {
            temperatures.add(temp);
            maxT = temp;
            minT = temp;
            avgT = temp;
        } else {
            if (temperatures.size() >= 1) {
                temperatures.add(temp);
                if (this.maxT < temp) {
                    this.maxT = temp;
                }
                if (this.minT > temp) {
                    this.minT = temp;
                }
                float totalT = 0;
                for (float temperature : temperatures) {
                    totalT += temperature;
                }

                this.avgT = totalT / temperatures.size();
            } else {
                return;
            }
        }
        display();
    }

    public void display() {

        System.out.println("Statistic Temperature,highest temperature:" + maxT
                + ";avg temperature:" + avgT + ";lowest temperature:" + minT);
    }

    public void unSubject(){
        weatherData.removeObserver(this);
    }
}
