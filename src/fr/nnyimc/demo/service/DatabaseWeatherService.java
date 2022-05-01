package fr.nnyimc.demo.service;

import org.springframework.stereotype.Component;

@Component
public class DatabaseWeatherService implements WeatherService {

	@Override
	public String getWeather() {
		return "Weather extracted from on-premises database is defined as: cloudy";
	}

}
