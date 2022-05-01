package fr.nnyimc.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomWeatherService implements WeatherService {
	
	@Value("${weather.list}")
	private String[] weatherList;
	
	private String selectRandomWeather() {
		Random random = new Random();
		int index = random.nextInt(weatherList.length);
		String weatherFortune = weatherList[index];
		return weatherFortune;
	}

	@Override
	public String getWeather() {
		return "Picked random weather: " + selectRandomWeather();
	}

}
