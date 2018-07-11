package org.zemo.observer;

import org.zemo.observer.observer.impl.CurrentConditionsDisplay;
import org.zemo.observer.observer.impl.StatisticsDisplay;
import org.zemo.observer.subject.impl.WeatherData;

/**
 * @ClassName: WeatherStation
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 06/06/2017 10:19
 * @Description ${TODO}
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(28, 65, 30.4f);
        weatherData.setMeasurements(30, 65, 30.4f);

        statisticsDisplay.unSubject();
        weatherData.setMeasurements(32, 65, 30.4f);

    }
}
