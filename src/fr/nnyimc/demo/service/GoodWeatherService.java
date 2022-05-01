package fr.nnyimc.demo.service;

import org.springframework.stereotype.Component;

@Component
public class GoodWeatherService implements WeatherService {

	@Override
	public String getWeather() {
		return "It's a sunny day!";
	}

}
