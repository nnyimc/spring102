package fr.nnyimc.demo.service;

import org.springframework.stereotype.Component;

@Component
public class RESTWeatherService implements WeatherService {

	@Override
	public String getWeather() {
		return "Weather extracted from external API is defined as windy!";
	}

}
