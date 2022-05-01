package fr.nnyimc.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.nnyimc.demo.service.WeatherService;

public class SwimCoach implements Coach {
	
	private WeatherService weatherService;
	
	public SwimCoach() {}
	
	@Autowired
	@Qualifier("randomWeatherService")
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Swim 1500 meters!";
	}

	@Override
	public String getDailyWeather() {
		return weatherService.getWeather();
	}

}
