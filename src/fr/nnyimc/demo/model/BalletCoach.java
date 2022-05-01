package fr.nnyimc.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.nnyimc.demo.service.WeatherService;

public class BalletCoach implements Coach {
	
	private WeatherService weatherService;
	
	public BalletCoach() {}

	@Autowired
	public BalletCoach(@Qualifier("databaseWeatherService") WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Do 15 pointes today!";
	}

	@Override
	public String getDailyWeather() {
		return weatherService.getWeather();
	}

}
